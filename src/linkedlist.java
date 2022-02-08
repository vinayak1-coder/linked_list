public class linkedlist {
    class Node{
        int element;
        Node next;
        public Node(int e,Node n){
            element= e;
            next= n;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public linkedlist(){
        head = null;
        tail = null;
        size = 0;
    }
    public int lenght(){
        return size;
    }
    public boolean isempty(){
        return size==0;
    }
    // add the element in the last
    public void addlast(int e){
        Node newest = new Node(e,null);
        if(isempty())
            head = newest;
        else
            tail.next= newest;
        tail = newest;
        size = size+1;
    }
    // add the element in the last
    public void addfir(int e){
        Node newest = new Node(e,null);
        if(isempty()){
            head = newest;
            //tail = newest;
        }
        else{
            newest.next = head;
            head = newest;
        }
        size = size+1;
    }
    // add the element anywhere at any position
    public void addany(int e, int pos){
        if(pos<=0 || pos>=size)
            System.out.println("invalid position");
        else {
            Node newest = new Node(e, null);
            Node p = head;
            int i = 0;
            while (i < pos - 1) {
                p = p.next;
                i = i + 1;
            }
            newest.next = p.next;
            p.next = newest;
        }
        size = size+1;

    }
    // deleting first element
    public int removefir(){
        if(isempty())
            System.out.println("empty list");
        int e = head.element;
        head = head.next;
        size=size-1;
        if(isempty())
            tail = null;
        return e;
    }
    // deleting the last element
    public int removeend(){
        if(isempty())
            System.out.println("empty list");
        Node p=head;
        int i=1;
        while(i<size-1){
            p=p.next;
            i=i+1;
        }
        tail = p;
        p=p.next;
        int e = p.element;
        tail.next=null;
        size=size-1;
        return e;
    }
    // deleting element from anywhere
    public int remobeany(int position){
        if (position<=0 || position >=size)
            System.out.println("invalid");
        Node p=head;
        int i=1;
        while (i<position-1){
            p=p.next;
            i=i+1;
        }
        int e=p.next.element;
        p.next=p.next.next;
        size=size-1;
        return e;
    }
    // searching any element in the linked list
    public int search(int key) {
        Node p = head;
        int index = 1;
        while(p!=null) {
            if(p.element==key)
                return index;
            p = p.next;
            index = index + 1;
        }
        return -1;
    }

    public void display(){
        Node p = head;
        while(p!=null){
            System.out.print(p.element+" ");
            p=p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        linkedlist l = new linkedlist();
        l.addlast(7);
        l.addlast(5);
        l.addlast(6);
        l.addlast(1);
        l.display();
        System.out.println("size "+ l.lenght());
        l.addfir(0);
        l.display();
        System.out.println("size "+ l.lenght());
        l.addany(4,4);
        //int element = l.removefir();
        //int element = l.removeend();
        //int element = l.remobeany(2);
        int position = l.search(4);
        l.display();
        System.out.println("size "+ l.lenght());
        System.out.println("Result: " + position);

    }
}
