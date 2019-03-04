package starcba;

public class BinList {
    public int currentindex = 0;
    public int arraybin[];

    public BinList(int size) {
        this.arraybin = new int[size];

    }

    public void insert(int data) {
        if (currentindex > this.arraybin.length - 1) {
            System.out.println("list is full");
        } else {
            this.arraybin[currentindex] = data;
            currentindex = currentindex + 1;
        }

    }

    public int binarySearch(int key) {
        int lBound = 0, ubound = this.arraybin.length - 1, currentIndex = 0;
        while (lBound < ubound) {
            currentIndex = (lBound + ubound) / 2;
            if (arraybin[currentIndex] == key) {
                return currentIndex;

            } else if (key > arraybin[currentIndex]) {
                lBound = currentIndex + 1;
            } else {
                ubound = currentIndex - 1;
            }
        }
        return -1;
    }







    public void printList() {

        for (int i = 0; i < arraybin.length; i++) {
            System.out.print(arraybin[i] + ", ");
        }
    }


}
