import java.io.*;
import java.util.*;

public class Solution {

   public static class Input {
        BufferedReader reader;
        StringBuilder string = new StringBuilder();

        public Input(BufferedReader reader) {
            this.reader = reader;
        }

        public Input(String str) {
            this.reader = new BufferedReader(new StringReader(str));
        }

        public String next() throws IOException {
            string.setLength(0);
            while (true) {
                int c = reader.read();
                if (c == -1) {
                    return null;
                }
                if (" \n\r\t".indexOf(c) == -1) {
                    string.append((char)c);
                    break;
                }
            }
            while (true) {
                int c = reader.read();
                if (c == -1 || " \n\r\t".indexOf(c) != -1) {
                    break;
                }
                string.append((char)c);
            }
            return string.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }
    }

    public static void solve(Input reader, PrintWriter out) throws IOException {
        int N = Integer.parseInt(reader.nextLine());
        TreeSet<Long> answer = new TreeSet<Long>();
        HashMap<String, Long> map1 = new HashMap<String, Long>();
        HashMap<String, Long> map2 = new HashMap<String, Long>();
        for (int i = 0; i < N; ++i) {
            String[] inputs = reader.nextLine().toLowerCase().split(",");
            long oid = Long.parseLong(inputs[0]);
            String id = inputs[1];
            String email = normalize(inputs[2]);
            String address = inputs[3].replace("st.", "street").replace("rd.", "road") + "," + inputs[4] + "," + replaceName(inputs[5]) + "," + inputs[6];
            if (map1.containsKey(id + ":" + email)) {
                answer.add(map1.get(id + ":" + email));
                answer.add(oid);
            }
            if (map2.containsKey(id + ":" + address)) {
                answer.add(map2.get(id + ":" + address));
                answer.add(oid);
            }
            map1.put(id + ":" + email, oid);
            map2.put(id + ":" + address, oid);
        }
        boolean first = true;
        for (long a : answer) {
            if (first) {
                first = false;
            } else {
                out.print(",");
            }
            out.print(a);
        }
        out.println();
    }

    public static String replaceName(String s) {
        if (s.equals("il")) return "illinois";
        if (s.equals("ca")) return "california";
        if (s.equals("ny")) return "new york";
        return s;
    }

    public static String normalize(String email) {
        String[] toks = email.split("@");
        if (toks[0].indexOf('+') != -1) {
            toks[0] = toks[0].substring(0, toks[0].indexOf('+'));
        }
        return toks[0].replace(".", "") + "@" + toks[1];
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        solve(new Input(new BufferedReader(new InputStreamReader(System.in))), out);
        out.close();
    }
}
