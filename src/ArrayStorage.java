/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        if (size == 0)
            System.out.println("Resume is empty");
        else {
            for (int i = 0; i < size; i++) {
                storage[i] = null;
            }
            size = 0;
        }
    }

    void save(Resume r) {
        if (size == storage.length)
            System.out.println("Resume is full");
        else {
            storage[size] = r;
            size++;
        }
    }

    String get(String uuid) {
        String answer = "";
        if (size == 0)
            answer = "Resume is empty";
        else {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    answer = storage[i].getUuid();
                    break;
                }
            }
        }
        if (answer == "")
            answer = "There is no such element";
        return answer;
    }

    void delete(String uuid) {
        int pos;
        if (size == 0)
            System.out.println("Resume is empty");
        else {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = null;
                    pos = i;
                    System.arraycopy(storage, pos + 1, storage, pos, size - (pos + 1));
                    size--;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] output = new Resume[size];
        System.arraycopy(storage, 0, output, 0, size);
        return output;
    }

    int size() {
        return size;
    }
}
