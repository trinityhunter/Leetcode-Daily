class Solution {

    public String simplifyPath(String path) {

        Stack<String> st = new Stack<>();

        String[] arr = path.split("/");

        for(int i=0; i<arr.length; i++){
            if(!st.empty() && arr[i].equals("..")){
                st.pop();
            }
            else if(!arr[i].equals(".") && !arr[i].equals("") && !arr[i].equals("..")){
                st.push(arr[i]);
            }
        }

        List<String> list = new ArrayList(st);

        return "/" + String.join("/", list);

    }

}
