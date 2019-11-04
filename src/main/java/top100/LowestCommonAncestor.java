package top100;

/**
 * @Auther: wwh
 * @Date: 2019/11/4 19:53
 * @Description:
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Inspired by : http://www.jiuzhang.com/solutions/lowest-common-ancestor/
 *给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身
 *
 * ? 1、怎么表示最近  如何遍历树
 *  第一次做  2019年11月4日21:04:49 看不懂答案  恍惚可以理解为什么是最小公共  因为在不断的向下递归 直到null
 * 参考
 * 思路1、递归不断向下运行直到null或者直到节点和给出的俩个点相同 这样可以保证找到的是最近的公共节点，
 * 2、最近的公共祖先不是二者公共的根节点 就是二者其中一个
 * 3、如果递归得到left和right都不为null  那么根节点就是答案，如果左右有一个是null  那么另外一个一定是和另外一个节点相同，
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        //若根为空  或者根和二者任何一个相同，则表明找到祖先了
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        //返回的节点可能是null也可能是node1 ,node2
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);

        // 都运行完毕后可以找到left和right  注意上面找left的递归是运行不到这里的，必须是运行完right才可以到这里
        if (left != null && right != null) { //如果都不为空  说明根节点就是答案
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

}
