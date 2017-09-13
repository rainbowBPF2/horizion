package designPattern.iterator;

/**
 * Created by pengfei on 2017/9/10.
 */
public class NameRepo implements Container {

    private String[] names = new String[]{"jack", "kelina", "susi"};

    @Override
    public Iterator getIter() {
        return new NameIter();
    }

    private class NameIter implements Iterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.length? true : false;
        }

        @Override
        public Object next() {
            if(this.hasNext())
                return names[index++];
            return null;
        }
    }
}
