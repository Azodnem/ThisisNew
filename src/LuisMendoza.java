/*
    Luis Mendoza
    input: Strings unsorted
    output: String assorted by using insertion sort

 */

import java.util.Scanner;

public class LuisMendoza {
    static class Node
    {
        //contains one data member and one previous and next reference
        String data;
        Node pre;
        Node next;

        public Node(String _data)
        {
            //this.data = data;
            data = _data;
            pre = null; //set to null to avoid reference to invalid node
            next = null;
        }
    }

    static class DLL
    {
        Node head; //used for inserting at begining
        Node tail; //used fro inserting at end

        public DLL() // initially set to NULL
        {
            head = null;
            tail = null;
        }

        // insert at the beginning
        public void insertAtStart( String data) // this works for CMD
        {
            Node newNode = new Node(data);

            if(head == null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                newNode.next = head;
                head.pre = newNode;
                head = newNode;
            }
        }


        //insert at the end
        public void insertAtEnd(String data)// this also works for CMD
        {
            Node newNode = new Node(data);
            if(tail == null)
            {
                head = tail = newNode;
            }
            else
            {
                tail.next = newNode;
                newNode.pre = tail;
                tail = tail.next;
            }
        }

        //Prints all elements unless there is non
        public void print()
        {
            if(head == null)
            {
                System.out.println("No Elements Present");
            }
            else
            {
                Node current = head;
                while(current != null)
                {
                    System.out.println(current.data );
                    current = current.next;
                }
                System.out.println("\n *********************************************************** \n"); // line up
            }
        }

        // important
        // the Algorithm using insertion sort
        public void insertion_sort()
        {
            if(head == null)
                return;
            else
            {
                // first node is sorted and second begins
                Node current = head.next;
                // runs till it reaches the end
                while(current != null)
                {
                    Node previous= current.pre; // holds the element present before current element
                    String current_data = current.data; // holds the current element data
                    Node temp_current = current; // temp_current used because current needs to changed also

                    while(previous != null && (previous.data).compareTo(current_data) > 0)
                    {
                        //compareTo returns 0 if equals else 1 or -1 for bigger or smaller

                        temp_current.data = previous.data;
                        //current data is changed to hold previous element data if previous is greater
                        previous.data = current_data;
                        // move both temp_current and previous one step back
                        previous = previous.pre;
                        temp_current = temp_current.pre;
                    }
                    //move current to next element
                    current = current.next;
                }
            }
        }
    }




        public static void main(String[] args)
        {


            DLL obj = new DLL(); // with cmd testing
            for(int i=0;i< args.length;i++)
            {
                obj.insertAtEnd(args[i]); // can use insert at end or start all optional
            }
            System.out.println("\nTraversal without Sorting\n");
            obj.print();

            obj.insertion_sort();

            System.out.println("Traversal after Sorting\n");
            obj.print();

        }



}
