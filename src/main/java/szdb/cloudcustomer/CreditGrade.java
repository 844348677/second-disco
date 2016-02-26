package szdb.cloudcustomer;

import org.apache.commons.lang3.StringUtils;
/**
 * Created by liuh on 2016/1/28.
 */


/**
 * 信用评级
 *
 * @author huxl
 *
 */
public class CreditGrade {

    private static double TREE_ONE = 0.19905107;
    private static double TREE_TWO = 0.13401921;
    private static double TREE_THREE = 0.30362777;

    private static double ALPHA_A = TREE_ONE * (-1) + TREE_TWO * (-1)
            + TREE_THREE * (-1);
    private static double ALPHA_B = TREE_ONE * 1 + TREE_TWO * (-1) + TREE_THREE
            * (-1);
    private static double ALPHA_C = TREE_ONE * (-1) + TREE_TWO * 1 + TREE_THREE
            * 1;

    /**
     * 信用评级
     *
     * @param treeOne
     * @param treeTwo
     * @param treeThree
     * @return
     */
    public static String grade(DSSTreeOne treeOne, DSSTreeTwo treeTwo,
                               DSSTreeThree treeThree) {

        double alpha = alphaSum(treeOne, treeTwo, treeThree);
        // A级
        if (alpha <= ALPHA_A) {

            return "A";
        }
        // B级
        if (alpha > ALPHA_A && alpha <= ALPHA_B) {

            return "B";
        }
        // C级
        if (alpha > ALPHA_B && alpha <= ALPHA_C) {

            return "C";
        }
        // D级
        if (alpha > ALPHA_C) {

            return "D";
        }
        return null;
    }

    /**
     *
     * 根据等级获取违约率 分ABCD四个等级
     *
     * @param grade
     * @return
     */
    public static double defaultRate(String grade) {

        double rate = 1;

        if (StringUtils.isNotBlank(grade)) {

            if ("A".equals(grade)) {
                rate = 0.063;
            } else if ("B".equals(grade)) {
                rate = 0.102;
            } else if ("C".equals(grade)) {
                rate = 0.147;
            } else if ("D".equals(grade)) {
                rate = 0.251;
            }

        }
        return rate;
    }

    private static double alphaSum(DSSTreeOne treeOne, DSSTreeTwo treeTwo,
                                   DSSTreeThree treeThree) {

        double result = treeOne.compare() * TREE_ONE + treeTwo.compare()
                * TREE_TWO;

        result += (treeThree.compare() * TREE_THREE);
        return result;
    }
}