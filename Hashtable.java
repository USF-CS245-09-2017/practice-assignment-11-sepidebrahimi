//Sepid Ebrahimi - CS245, Section 1

public class Hashtable {

        private HashNode[] slots;
        private int size;


        public Hashtable() { //constructor
            slots = new HashNode[1000];
            size = 0;
        }

        private int getSlot(String key){ // get the slot
            int hashCode = Math.abs(key.hashCode());
            int index = hashCode % slots.length;
            return index;
        }

        boolean containsKey (String key) { // find function
            int pos = getSlot(key);
            if(slots[pos] != null) {
                HashNode tmp = slots[pos];
                while(tmp.next != null) { // while there is another node available
                    if(tmp.key().equals(key)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public String get(String key) { //get the value
            int pos = getSlot(key);
            HashNode spot = slots[pos];

            while(spot != null) { // the slot's position is not null
                if(spot.key == key) {
                    return spot.value();
                }
                spot = spot.next;
            }
            return null;
        }

        public void put (String key, String value) { //put a node with a key and a value
            int pos = getSlot(key);
            HashNode head = slots[pos];
            HashNode start = new HashNode(key, value);
            start.next = head;
            slots[pos] = start;
            size++;
        }

        public String remove(String key) { //remove a node
            int pos = getSlot(key);
            HashNode head = slots[pos];

            if(head == null) {
                return null;
            }
            if(head.key() == key) {
                slots[pos] = head.next;
                size--;
                return head.value();
            }

            HashNode prev = null;
            while(head != null) {
                if(head.key().equals(key)) {
                    prev.next = head.next;
                    size--;
                    return head.value();
                }
                prev = head;
                head = head.next;
            }
            return head.value();
        }
}
