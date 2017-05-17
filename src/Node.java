    public class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            //this.time = time;
            this.next = null;
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
        /**
         * Adds a new node at the specified index.
         * @param head Current head.
         * @param index The index of the list.
         * @param value The value being added into the list.
         * @return newHead.
         */


        /**
         * Gets the data in this node.
         *
         * @return the data in this node.
         */
        public String getData() {
            return this.data;
        }


        /**
         * Gets the next node in the list.
         *
         * @return the next node in the list.
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Updates the node that follows this node with the given node.
         *
         * @param next
         *            the new node that follows this node.
         */
        public void setNext(Node next) {
            this.next = next;
        }

    }
