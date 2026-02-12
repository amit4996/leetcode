class MyCalendarTwo {
    List<int[]> calendar;
    List<int[]> overlap;
    public MyCalendarTwo() {
        calendar=new ArrayList<>();
        overlap=new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {

        for(int i=0;i<overlap.size();i++){
            int [] temp = overlap.get(i);
            if(Math.max(startTime,temp[0])<Math.min(endTime,temp[1])){
                return false;
            }
        }

        for(int i=0;i<calendar.size();i++){
            int [] temp = calendar.get(i);
            if(Math.max(startTime,temp[0])<Math.min(endTime,temp[1])){
                overlap.add(new int[]{Math.max(startTime,temp[0]),Math.min(endTime,temp[1])});
            }
        }
        calendar.add(new int[]{startTime,endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */