class FoodPair {
    String food;
    String cuisine;
    int rating;
    
    public FoodPair(String food, String cuisine, int rating){
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

class FoodRatings {
    HashMap<String, PriorityQueue<FoodPair>> map;
    HashMap<String, FoodPair> fpmap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        fpmap = new HashMap<>();
        for (int i=0; i<foods.length; i++){
            FoodPair fp = new FoodPair(foods[i], cuisines[i], ratings[i]);
            fpmap.put(foods[i], fp);
            map.computeIfAbsent(cuisines[i], f->new PriorityQueue<FoodPair>(
                (a,b)->a.rating!=b.rating ? b.rating-a.rating : a.food.compareTo(b.food))).add(fp);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = fpmap.get(food).cuisine;
        fpmap.get(food).rating = newRating;
        map.get(cuisine).remove(fpmap.get(food));
        map.get(cuisine).add(fpmap.get(food));
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
