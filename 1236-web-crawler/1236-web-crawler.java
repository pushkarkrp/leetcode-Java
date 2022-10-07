/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    
    private String getHostName(String s) {
        String[] sl = s.split("/");
        return sl[2];
    }
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Queue<String> queue  = new LinkedList<>();
        Set<String> set = new HashSet<>();
        String hostName = getHostName(startUrl);
        queue.add(startUrl);
        set.add(startUrl);
        while (!queue.isEmpty()) {
            String node = queue.poll();
            for (String s : htmlParser.getUrls(node)) {
                if (s.contains(hostName) && !set.contains(s)) {
                    set.add(s);
                    queue.add(s);
                }
            }
        }
        return new ArrayList<>(set);
    }
}