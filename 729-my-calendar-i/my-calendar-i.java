class MyCalendar {
    List<int[]> calendar;
    public MyCalendar() {
        calendar=new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        boolean book=true;
        for(int i=0;i<calendar.size();i++){
            int[] temp=calendar.get(i);
             if (startTime < temp[1] && temp[0] < endTime) {
                return false;
            }
        }
        calendar.add(new int[]{startTime,endTime});
        return book;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */