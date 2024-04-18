class Solution {    

    public int islandPerimeter(int[][] grid) {
        
        int ans = 0;
        
        if(grid.length == 1 && grid[0].length == 1){
            return 4;
        }
        
        if(grid.length==1){
            for(int j=0; j<grid[0].length; j++){
                int i=0;
                if(grid[i][j]==1){
                    if(i==0 && j==0){
                        ans += 3;
                        if(grid[i][j+1]==0){
                            ans++;
                        }
                        
                    }
                    else if(i==0 && j==grid[0].length-1){
                        ans += 3;
                        if(grid[i][j-1]==0){
                            ans++;
                        }
                    }
                    else{
                        ans += 2;
                        if(grid[i][j+1]==0){
                            ans++;
                        }
                        if(grid[i][j-1]==0){
                            ans++;
                        }
                    }
                }
            }
        }
        else if(grid[0].length==1){
            for(int i=0; i<grid.length; i++){
                int j=0;
                if(grid[i][j]==1){
                    if(i==0 && j==0){
                        ans += 3;
                        if(grid[i+1][j]==0){
                            ans++;
                        }
                    }
                    else if(i==grid.length-1 && j==0){
                        ans += 3;
                        if(grid[i-1][j]==0){
                            ans++;
                        }
                    }
                    else{
                        ans += 2;
                        if(grid[i-1][j]==0){
                            ans++;
                        }
                        if(grid[i+1][j]==0){
                            ans++;
                        }
                    }
                }
            }
        }
        else if(grid.length >1 && grid[0].length > 1){
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j]==1){
                        if(i==0 && j==0){
                            ans += 2;
                            if(grid[i][j+1]==0){
                                ans++;
                            }
                            if(grid[i+1][j]==0){
                                ans++;
                            }
                        }
                        else if(i==0 && j==grid[0].length-1){
                            ans += 2;
                            if(grid[i][j-1]==0){
                                ans++;
                            }
                            if(grid[i+1][j]==0){
                                ans++;
                            }
                        }
                        else if(i==grid.length-1 && j==0){
                            ans += 2;
                            if(grid[i][j+1]==0){
                                ans++;
                            }
                            if(grid[i-1][j]==0){
                                ans++;
                            }
                        }
                        else if(i==grid.length-1 && j==grid[0].length-1){
                            ans += 2;
                            if(grid[i][j-1]==0){
                                ans++;
                            }
                            if(grid[i-1][j]==0){
                                ans++;
                            }
                        }
                        else if(i==0 && j!=0 && j!=grid[0].length-1){
                            ans++;
                            if(grid[i][j-1] == 0){
                                ans++;
                            }
                            if(grid[i+1][j] == 0){
                                ans++;
                            }
                            if(grid[i][j+1] == 0){
                                ans++;
                            }
                        }
                        else if(i==grid.length-1 && j!=0 && j!=grid[0].length-1){
                            ans++;
                            if(grid[i-1][j] == 0){
                                ans++;
                            }
                            if(grid[i][j-1] == 0){
                                ans++;
                            }
                            if(grid[i][j+1] == 0){
                                ans++;
                            }
                        }
                        else if(j==0 && i!=0 && i!=grid.length-1){
                            ans++;
                            if(grid[i-1][j] == 0){
                                ans++;
                            }
                            if(grid[i+1][j] == 0){
                                ans++;
                            }
                            if(grid[i][j+1] == 0){
                                ans++;
                            }
                        }
                        else if(j==grid[0].length-1 && i!=0 && i!=grid.length-1){
                            ans++;
                            if(grid[i-1][j] == 0){
                                ans++;
                            }
                            if(grid[i][j-1] == 0){
                                ans++;
                            }
                            if(grid[i+1][j] == 0){
                                ans++;
                            }
                        }
                        else{
                            if(grid[i-1][j] == 0){
                                ans++;
                            }
                            if(grid[i][j-1] == 0){
                                ans++;
                            }
                            if(grid[i+1][j] == 0){
                                ans++;
                            }
                            if(grid[i][j+1] == 0){
                                ans++;
                            }
                        }
                    }

                }
            }
        }
        
        
        return ans;       
        
    }
    
}
