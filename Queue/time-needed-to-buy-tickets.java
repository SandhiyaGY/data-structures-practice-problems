class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.add(new int[] {tickets[i],i});
        }
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int top=cur[0];
            int index=cur[1];
            time++;
            if((top-1)>0){
                q.add(new int[] {top-1,index});
            }if(index ==k && (top-1)==0){
                break;
            }
        }
        return time;
    }
}
