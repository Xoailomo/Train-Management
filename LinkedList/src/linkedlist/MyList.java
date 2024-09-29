package LinkedList;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(int x) {
        if (isEmpty()) {
            Node p = new Node(x, null);
            head = tail = p;
        } else {
            Node p = new Node(x, null);
            tail.next = p;
            tail = p;
        }
    }

    public void addFirst(int x) {
        if (isEmpty()) {
            Node p = new Node(x, null);
            head = tail = p;

        } else {
            Node p = new Node(x, null);
            p.next = head;
            head = p;
        }
    }

    public void addManyLast(int x[]) {
        int i;
        for (i = 0; i < x.length; i++) {
            addLast(x[i]);
        }
    }

    public void addManyFirst(int x[]) {
        for (int i = 0; i < x.length; i++) {
            addFirst(x[i]);
        }
    }

    public void visit(Node p) {
        System.out.print(" " + p.info);
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();

    }

    public Node getFirst() {
        return head;

    }

    public Node getLast() {
        return tail;
    }

    public Node get(int x) {
        Node p = head;
        while (p != null) {
            if (p.info == x) {
                return p;
            } else {
                p = p.next;
            }

        }
        return null;
//        while(p != null && p.info !=x){
//            p=p.next;
//        }
//        return p;
    }

    public Node getNext(Node p) {
        if (p != null) {
            return p = p.next;
        }
        return null;
    }

    public Node getPrev(Node p) {
        Node d = head;
//        while( d != null && d.next != p){
//            d= d.next;
//        }
//        return d;
        if (p == head) {
            return null;
        }
        Node prev = null;
        while (d != null && d != p) {
            prev = d;
            d = d.next;
        }
        return prev;

    }

    public int size() {
        Node p = head;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }

    public Node getByIndex(int index) {
        Node p = head;
        int i = 0;
        while (p != null && i != index) {
            i++;
            p = p.next;

        }
        return p;
    }

    public void insertAfter(Node p, int x) {
        Node q = head;
        // p | null ====> q | null
        // q.next = p.next
        // p.next = q
        if (p != tail) {
            while (q != null && q != p) {
                q = q.next;
            }
            p.next.info = x;
        } else {
            addLast(x);
        }

    }

    public void inserBefore(Node p, int x) {
        Node q = head;
        Node tmp = new Node(x, null);
        if (p != head) {
            Node prev = getPrev(p);
            prev.next = tmp;
            tmp.next = p;

        } else {
            addFirst(x);
        }
    }

    public void insert(int index, int x) {
        if (index == 0) {
            inserBefore(head, x);
        } else {
            Node insertNodeIndex = getByIndex(index);
            inserBefore(insertNodeIndex, x);
        }

    }

    public void remove(Node p) {
        if (head == tail) {
            head = tail = null;
        } else {
            if (p == head) {
                Node q = head.next;
                head = null;
                head = q;
            } else if (p == tail) {
                Node q = getPrev(p);
                q.next = null;
            } else {
                Node q = head;
                while (q != null && q != p) {
                    q = q.next;
                }
                getPrev(q).next = p.next;
            }
        }
    }
//   public  void remove2 (Node p){
//        if(head == tail){
//            head=tail=null;
//        }else{
//            Node prev= getPrev(p);
//            prev.next = p.next;
//            p.next = null;
//        }
//    }

    public void removeByIndex(int index) {
        int i = 0;
        while (i != index) {
            i++;
        }
        remove(getByIndex(index));
    }

    public void removeAfter(Node p) {
        Node q = head;
        if (p == tail) {
            return;
        } else {
            while (q != null && q != getNext(p)) {
                q = q.next;
            }
        }
        p.next = getNext(p).next;
    }

    public void removeBefore(Node p) {
        Node q = head;
        if (p == head) {
            return;
        }
        while (q != null && q != getPrev(p)) {
            q = q.next;
        }
        getPrev(q).next = getPrev(p).next;
    }

    public void set(Node p, int x) {
        if (p == head) {
            getPrev(p.next).info = x;
        } else if (p == tail) {
            getNext(getPrev(p)).info = x;
        } else {
            Node q = head;
            while (q != null && q != p) {
                q = q.next;
            }
            p.info = x;
        }

    }

    // find max
    public Node max() {
        Node p = head;
        Node max = p;
        while (p != null) {
            if (p.info >= max.info) {
                max = p;
            }
            p = p.next;
        }
        return max;
    }

    // check again
    public Node secondMax() {
        Node p = head;
        Node max = max();
        Node secondMax = head;
        if (p.info == max.info) {
            secondMax = p.next;
        } else {
            secondMax = p;
        }
        while (p != null) {
            if (p.info >= secondMax.info && p.info < max.info) {
                secondMax = p;
            }
            p = p.next;
        }
        return secondMax;
    }

    public void swap(Node p, Node q) {
//        while (q != null && p != null) {
//            Node temp = new Node();
//            temp.info = p.info;
//            p.info = q.info;
//            q.info = temp.info;
//        }
//        return;
        if (p == null || q == null) {
            return;
        }
        int temp = p.info;
        p.info = q.info;
        q.info = temp;
    }

    public void sort() {
//        Node a = new Node();
//        if(q==p && q.next == null) return;
//        while (a.info == p.info && a.info != q.info) {
//            if(a.info > a.next.info){
//                swap(a, a.next);
//            }
//            a= a.next;
//        }
//        for (Node a = p; a != q; a = a.next) {
//            for (Node b = a.next; b != q.next; b = b.next) {
//                if (b.info < a.info) {
//                    swap(a, b);
//                }
//            }
//        }
        Node p = head;
        while (p != null) {
            Node q = p.next;
            while (q != null) {
                if (q.info < p.info) {
                    swap(p, q);
                }
                q = q.next;
            }
            p = p.next;
//        for (int i = 0; i < size() - 1; i++) {
//            for (int j = i + 1; j < size(); j++) {
//                if (getByIndex(i).info > getByIndex(j).info) {
//                    swap(getByIndex(i), getByIndex(j));
//                }
//            }
//        }
        }
    }
    public void sortDesc() {
        Node p = head;
        while (p != null) {
            Node q = p.next;
            while (q != null) {
                if (q.info > p.info) {
                    swap(p, q);
                }
                q = q.next;
            }
            p = p.next;
        }
    }
    public void sortByNode(Node p, Node q){
        for(Node a = p; a!=q;a=a.next){
            for(Node b=a.next;b!=q.next;b=b.next){
                if(b.info<a.info){
                    swap(a, b);
                }
            }
        }
    }
    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;
        tail=head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        
    }
}
