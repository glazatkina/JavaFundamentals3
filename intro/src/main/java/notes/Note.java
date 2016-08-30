package notes;

/**
 * Created by Natalia Glazkina on 30.08.2016.
 */
public class Note {
    private Records[] notes;
    private int size;

    Note() {
        notes = new Records[2];
        size = 0;
    }

    /**
     * Adding record in note. If array's length smaller than new index - creates new array with double length.
     * @param message
     *          text of record.
     */
    public void addRecord(String message) {
        if (size < notes.length) {
            notes[size] = new Records(message);
            size++;
        } else {
            Records[] arr = new Records[notes.length * 2];
            System.arraycopy(notes, 0, arr, 0, notes.length);
            notes = arr;
            notes[size] = new Records(message);
            size++;
        }
    }

    /**
     *  Editing record in note.
     * @param row
     *          record's index,
     * @param message
     *          new text for record.
     * @return true - editing successful, false - row index out of array's indexes.
     */
    public boolean editRecord(int row, String message) {
        if (row > size) {
            return false;
        } else {
            notes[row].setRecord(message);
            return true;
        }
    }

    /**
     * Deleting record in note.
     * @param row
     *          record's index.
     * @return true - deleting succesful, false - row index out of array's indexes.
     */
    public boolean deleteRecord(int row) {
        if (row > size) {
            return false;
        } else {
            System.arraycopy(notes, row + 1, notes, row, notes.length - row - 1);
            size--;
            return true;
        }
    }

    /**
     * Print all records from note.
     */
    public void printRecords() {
        System.out.println("Notes: ");
        for (int i = 0; i < size; ++i) {
            System.out.println(notes[i].getRecord());
        }
        System.out.println("________________________________________________");
    }

    public static void main(String[] args) {
        Note testNote = new Note();
        //test for adding
        for (int i = 0; i < 10; ++i) {
            testNote.addRecord("Test record " + i);
        }
        testNote.printRecords();

        //test for deleting
        for (int i = 0; i < 10; i += 2) {
            testNote.deleteRecord(i);
        }
        testNote.printRecords();

        //test for editing
        testNote.editRecord(0, "This is first record!");
        testNote.printRecords();
    }
}
