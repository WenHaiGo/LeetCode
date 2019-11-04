package top100;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: wwh
 * @Date: 2019/11/4 20:06
 * @Description:
 */
public class LowestCommonAncestorTest {

    @Test
    public void lowestCommonAncestor() {
        ArrayList<TreeNode> inputeRoots = new ArrayList<TreeNode>();
        ArrayList<TreeNode> inputeAs = new ArrayList<TreeNode>();
        ArrayList<TreeNode> inputeBs = new ArrayList<TreeNode>();
        ArrayList<TreeNode> results = new ArrayList<TreeNode>();

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n0.left = n1;
        n0.right = n2;
        inputeRoots.add(n0);
        inputeAs.add(n1);
        inputeBs.add(n2);
        results.add(n0);

        for (int i = 0; i < results.size(); i++) {
            LowestCommonAncestor l = new LowestCommonAncestor();
            TreeNode r = l.lowestCommonAncestor(inputeRoots.get(i), inputeAs.get(i), inputeBs.get(i));
            assertEquals(results.get(i).val, r.val);
        }
    }
}