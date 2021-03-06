package veriyapıları_hmw5;

public class MID_2 {
    HashEntry [] table;
    
    MID_2(int size){
        table = new  HashEntry [size];
    }
    
    void put(int key, String value){
        //başla
        int hash = key*key;
        //bitir
        
        hash = hash % table.length;

        boolean added = false;

        for (int i = 0; i < table.length; i++) {
            if( table[(hash+i)%table.length] == null || table[(hash+i)%table.length].key == key){
                table[(hash+i)%table.length] = new HashEntry(key, value);
                added = true;
                break;
            }
        }
        if ( added == false)
            System.out.println(value + " tabloya eklenemedi");
    }
    
    String get(int key){
        String aranan = " tabloda bulunamadı";
        
        //başla
        int hash = key*key;
        //bitir
        
        hash = hash % table.length;
        //
        for (int i = 0; i < table.length && table[(hash+i)%table.length] != null; i++) {
            if( table[(hash+i)%table.length].key == key)
                aranan = table[(hash+i)%table.length].value;
        }
        return aranan;
    }
    
    void printTable(){
        for (int i = 0; i < table.length; i++) {
            System.out.print("[" + i + "] ");
            if( table[i] != null)
                System.out.println( table[i].key + " : " + table[i].value);
            else
                System.out.println("");
        }
    }
    
    
    class HashEntry{
        int key;
        String value;
        
        HashEntry(int key, String value){
            this.key = key;
            this.value = value;
        }
        
    }
}
