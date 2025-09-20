package Graph.TopoSortAndProblem;
import java.util.* ;
public class AlienDictionary {
    public class Solution {
        private static ArrayList <ArrayList<Integer>> adjList ;
        public static String getAlienLanguage(String []dictionary, int k) {
            //Edge case
            if(dictionary == null || dictionary.length == 0) {
                return "" ;
            }

            //Build the AdjList
            int[] inDegree = new int[k] ;
            buildTheAdjList(dictionary , inDegree , k) ;

            //Find the topoSort
            String topoSort = findTopologicalSort(inDegree ,k) ;

            return topoSort ;
        }

        private static void buildTheAdjList(String[] dictionary , int[] inDegree , int k ) {
            adjList = new ArrayList <ArrayList<Integer>> () ;
            for(int i = 0 ; i < k ; i++) {
                adjList.add(new ArrayList<Integer>()) ;
            }

            for(int i = 0 ; i < dictionary.length - 1 ; i++ ) {
                String firstWord = dictionary[i] ;
                String secondWord = dictionary[i + 1] ;

                int minLength = Math.min(firstWord.length() , secondWord.length()) ;

                for(int idx = 0 ; idx < minLength ; idx++ ) {
                    char firstChar = firstWord.charAt(idx) ;
                    char secondChar = secondWord.charAt(idx) ;

                    if(firstChar != secondChar) {
                        adjList.get(firstChar - 'a').add(secondChar - 'a') ;
                        inDegree[secondChar - 'a']++ ;
                        break ;
                    }
                }
            }
            return ;
        }

        private static String findTopologicalSort(int[] inDegree , int k ) {
            Queue <Integer> queue = new LinkedList<> () ;
            for(int i = 0 ; i < k ; i++) {
                if(inDegree[i] == 0) {
                    queue.add(i) ;
                }
            }

            StringBuilder ans = new StringBuilder() ;
            while (!queue.isEmpty()) {
                int node = queue.poll() ;
                char currentChar = (char)(node + 'a') ;
                ans.append(currentChar) ;

                for(int i = 0 ; i < adjList.get(node).size() ; i++ ) {
                    int neighbor = adjList.get(node).get(i) ;
                    inDegree[neighbor]-- ;

                    if(inDegree[neighbor] == 0) {
                        queue.add(neighbor) ;
                    }
                }
            }

            return ans.toString() ;
        }
    }
    public static void main(String[] args) {

    }
}
