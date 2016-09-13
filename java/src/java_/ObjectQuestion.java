package java_;

import java.util.Arrays;
import java.util.List;

public class ObjectQuestion
{
    
}

/**
 * 
 * @author zhinengsheng
 *
 */
class HashcodeQuestion
{
    static class Class1
    {
        private byte b;
        private int i;
        private int[] iArray;
        private List<Integer> iList;
        private short s;
        private long l;
        private float f;
        private double d;
        private char c;
        private boolean bool;
        private String string;
        
        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + b;
            result = prime * result + (bool ? 1231 : 1237);
            result = prime * result + c;
            long temp;
            temp = Double.doubleToLongBits(d);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            result = prime * result + Float.floatToIntBits(f);
            result = prime * result + i;
            result = prime * result + Arrays.hashCode(iArray);
            result = prime * result + ((iList == null) ? 0 : iList.hashCode());
            result = prime * result + (int) (l ^ (l >>> 32));
            result = prime * result + s;
            result = prime * result + ((string == null) ? 0 : string.hashCode());
            return result;
        }
    }
}
