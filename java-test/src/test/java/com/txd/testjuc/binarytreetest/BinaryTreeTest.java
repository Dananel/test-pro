package com.txd.testjuc.binarytreetest;

import com.txd.datastructure.tree.BinaryTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryTreeTest {

    private static BinaryTree  binary = null;

    @BeforeClass
    public static void initTest(){
        if(binary == null){
            binary = new BinaryTree();
        }
    }

    @Before
    public void  testInsert(){
        binary.insertValue(9);
        binary.insertValue(11);
    }

    @Test
    public void testPreSearch(){
        System.out.println("先序遍历");
        binary.preSearch();
    }

    @Test
    public void testMiddleSearch(){
        System.out.println("中序遍历");
        binary.middleSearch();
    }

    @Test
    public void testLastSearch(){
        System.out.println("后序遍历");
        binary.lastSearch();
    }

    @Test
    public void testPreSeachNode(){
        System.out.println("前序搜素");
        BinaryTree.TreeNode treeNode = binary.preSearchNode(9);
        System.out.println(treeNode);
        Assert.assertNotNull(treeNode);
    }
}
