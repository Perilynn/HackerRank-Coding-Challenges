import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class Solution {

    public static Hashtable<String, List<Record>> fraudsEmail = new Hashtable<String, List<Record>>();
    public static Hashtable<String, List<Record>> fraudsAddr = new Hashtable<String, List<Record>>();
    public static TreeSet<Integer> fraudsOrder = new TreeSet<Integer>();

    public static class Address {
        protected String streetAddr;
        protected String city;
        protected String state;
        protected String zip;
    }

    public static class Record {
        protected String orderID;
        protected String dealID;
        protected String email;
        protected Address addr;
        protected String card;
    }

    private static Record createRecord(String[] input) {
        Address addr = new Address();
        Record rec = new Record();
        addr.streetAddr = input[3];
        addr.city = input[4];
        addr.state = input[5];
        addr.zip = input[6];
        rec.addr = addr;
        rec.orderID = input[0];
        rec.dealID = input[1];
        rec.email = input[2];
        rec.card = input[7];
        return rec;
    }

    private static String parseEmailKey(String email) {
        String [] emailInput = email.split("@");
        String username = emailInput[0].toLowerCase();
        String emailKey = username.contains("+") ? username.split("\\+")[0] : username;
        emailKey = emailKey.replace(".", "");
        return emailKey;
    }

   
    private static void detectFraudEmail(Record rec) {
        String emailKey = parseEmailKey(rec.email);
        String fraudsEmailKey = emailKey + rec.dealID;
        if ( fraudsEmail.containsKey(fraudsEmailKey) ) {
            List<Record> recList = fraudsEmail.get(fraudsEmailKey);
            for (Record r : recList) {
                if ( !rec.card.equals(r.card) ) {
                    fraudsOrder.add( Integer.parseInt(rec.orderID) );
                    fraudsOrder.add( Integer.parseInt(r.orderID) );
                }
            }
            recList.add( rec );
        } else {
            fraudsEmail.put( fraudsEmailKey, new ArrayList<Record> () );
            fraudsEmail.get( fraudsEmailKey ).add( rec );
        }
    }

    
    private static String createAddrKey(Address addr) {
        String stAddr = addr.streetAddr.toLowerCase();
        String city = addr.city.toLowerCase();
        String state = addr.state.toLowerCase();
        String zip = addr.zip;
        
        int length = stAddr.length();
        String lastTokenStAddr = stAddr.substring( length-3 );
        if ( lastTokenStAddr.equals("st.") ) {
            stAddr = stAddr.substring( 0, length-3 ) + "street";
        } else if ( lastTokenStAddr.equals("rd.") ) {
            stAddr = stAddr.substring( 0, length-3 ) + "road";
        }

        if ( state.equals("new york") ) {
            state = "ny";
        } else if ( state.equals("california") ) {
            state = "ca";
        } else if ( state.equals("illinois") ) {
            state = "il";
        }
        return stAddr + city + state + zip;
    }

    /**
    *   Function to detect frauds type: same address, same deal id, different
    *   credit card.
    */
    private static void detectFraudAddr(Record rec) {
        String addrKey = createAddrKey(rec.addr);
        String fraudsAddrKey = addrKey + rec.dealID;
        if ( fraudsAddr.containsKey(fraudsAddrKey) ) {
            List<Record> recList = fraudsAddr.get( fraudsAddrKey );
            for (Record r : recList) {
                if ( !rec.card.equals(r.card) ) {
                    fraudsOrder.add( Integer.parseInt(rec.orderID) );
                    fraudsOrder.add( Integer.parseInt(r.orderID) );
                }
            }
            recList.add( rec );
        } else {
            fraudsAddr.put( fraudsAddrKey, new ArrayList<Record> () );
            fraudsAddr.get( fraudsAddrKey ).add( rec );
        }
    }


      public static void main(String [] args) throws IOException {
        BufferedReader in = new BufferedReader( new InputStreamReader ( System.in ) );
        int testCase = Integer.parseInt( in.readLine() );
        for (int i = 0; i < testCase; i++) {
            String line = in.readLine();
            String [] input = line.split(",");
            Record rec = createRecord( input );
            detectFraudEmail(rec);
            detectFraudAddr(rec);
        }
        
        String lineToPrint = "";
        Iterator<Integer> iter = fraudsOrder.iterator();
        while ( iter.hasNext() ) {
            lineToPrint += iter.next() + ",";
        }
        if ( !lineToPrint.equals("") ) {
            lineToPrint = lineToPrint.substring( 0, lineToPrint.length()-1);
        }
        System.out.println( lineToPrint );

    }
}
