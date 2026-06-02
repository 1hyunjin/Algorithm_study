import java.util.*;
class Solution {
    static Map<String, List<Ticket>> graph;
    static List<String> path;
    static int ticketCount;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        graph = new HashMap<>();
        path = new ArrayList<>();
        ticketCount = tickets.length;
        
        for(String[] ticket : tickets){
            String from = ticket[0];
            String to = ticket[1];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new Ticket(to));
        }
        for(String from : graph.keySet()){
            Collections.sort(graph.get(from));
        }
        
        path.add("ICN");
        dfs("ICN", 0);
        
        return path.toArray(new String[0]);
    }
    public static boolean dfs(String current, int usedCount){
        if(usedCount == ticketCount){
            return true;
        }
        List<Ticket> tickets = graph.get(current);
        if(tickets == null){
            return false;
        }
        for(Ticket ticket : tickets){
            if(!ticket.used){
                ticket.used = true;
                path.add(ticket.to);
                
                if(dfs(ticket.to, usedCount+1)){
                    return true;
                }
                path.remove(path.size()-1);
                ticket.used = false;
            }
        }
        return false;
    }
    public static class Ticket implements Comparable<Ticket>{
        String to;
        boolean used;
        
        public Ticket(String to){
            this.to = to;
            this.used = false;
        }
        @Override
        public int compareTo(Ticket other){
            return this.to.compareTo(other.to);
        }
        @Override
        public String toString(){
            return "{ " + this.to + " }";
        }
    }
}