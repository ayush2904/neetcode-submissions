class Solution {

    public String encode(List<String> strs) {
       String str = strs.stream().map(s-> s.length()+"#"+s).collect(Collectors.joining(""));
       System.out.println(str); 
       return str;
    }

    public List<String> decode(String str) {
        List<String> d = new ArrayList<>();
        int j=0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '#') {
                int t = Integer.parseInt(str.substring(j,i));
                String r = str.substring(i+1,i+t+1);
                d.add(r);
                System.out.println(r);
                i=i+t;
                j=i+1;
            }
        }
        //System.out.println(d);
        return d;
    }
}
