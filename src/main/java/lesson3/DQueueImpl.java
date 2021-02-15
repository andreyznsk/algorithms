package lesson3;

public class DQueueImpl<E> extends QueueImpl<E> implements DQueue<E> {

    public DQueueImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if(head==DEFAULT_HEAD)
            head = data.length;

        data[--head] = value;
        size++;
        return true;

       /* if(size == 0) {
            data[head] = value;
            size++;
            tail = DEFAULT_HEAD;
            return true;
        }

        //Проверка если из дек удалялись элемнты слева и голова указывает не на 0 элемент массива
        if (tail!=data.length-1&&head>0){
            data[--head] = value;
            size++;
            return true;
        }

        if(tail!=data.length-1&&head==0) {
            for (int i = tail; i >=0 ; i--) {
                data[i + 1] = data[i];
            }
            data[head] = value;
            tail++;
            size++;
            return true;
        }

        data[head--] = value;

        if (head < DEFAULT_HEAD) {
            tail = DEFAULT_TAIL;
        }

        size++;
        return true;*/
    }

    @Override
    public boolean insertRight(E value) {
        return insert(value);

    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        if (tail == -1) {
            tail = data.length-1;
        }
        E removedValue = data[tail];
        data[tail--] = null;
        size--;
        return removedValue;
    }

    @Override
    public E removeLeft() {
        return remove();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @SuppressWarnings("DuplicatedCode")
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Текущий ДЕК: [");
            if (this.size == 0) return "Дек пустой";

            for (int i = 0; i < data.length; i++) {
                sb.append(data[i]);
                sb.append(", ");
            }

            sb.append("]");

            return sb.toString();
        }
    }
