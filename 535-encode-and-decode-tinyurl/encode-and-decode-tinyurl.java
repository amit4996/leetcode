public class Codec {
    private Map<String,String> mp = new HashMap();
    private int counter=0;
    private final String BASE_URL="http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key=Integer.toString(counter);
        mp.put(key,longUrl);
        counter++;
        System.out.println(BASE_URL+key);
        System.out.println(mp);
        return BASE_URL+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key=shortUrl.replace(BASE_URL,"");
         return mp.get(key);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));