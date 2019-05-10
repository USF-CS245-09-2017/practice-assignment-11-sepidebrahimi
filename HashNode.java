//Sepid Ebrahimi - CS245, Section 1

public class HashNode {

        String key;
        String value;
        HashNode next; //next node


        public HashNode(String key, String value) { //constructor
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public String key() {
            return this.key;
        } //returns key
        public String value() {
            return this.value;
        } //returns key

}
