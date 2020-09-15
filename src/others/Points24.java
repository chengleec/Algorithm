package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglee
 * @date 2020/8/30 15:41
 * @description
 */
public class Points24 {
    public static boolean points24(List<Double> list){
        if (list.size() == 1){
            return Math.abs(list.get(0) - 24) <= 0.00001;
        }
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                boolean valid = false;
                List<Double> copy = new ArrayList<>(list);
                double a = copy.remove(i), b = copy.remove(j);
                copy.add(a + b);
                valid |= points24(copy);
                copy.set(copy.size()-1, a - b);
                valid |= points24(copy);
                copy.set(copy.size()-1, b - a);
                valid |= points24(copy);
                copy.set(copy.size()-1, a * b);
                valid |= points24(copy);
                copy.set(copy.size()-1, a / b);
                valid |= points24(copy);
                copy.set(copy.size()-1, b / a);
                valid |= points24(copy);
                if (valid) return true;
            }
        }
        return false;
    }
}
