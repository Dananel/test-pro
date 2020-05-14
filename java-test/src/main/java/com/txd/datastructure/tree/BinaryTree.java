package com.txd.datastructure.tree;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 二叉树：搜索二叉树
 */
@Data
@Getter
@Setter
public class BinaryTree {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public BinaryTree() {
        root = new TreeNode(10);
    }

    public BinaryTree(int value) {
        root = new TreeNode(value);
    }

    public void insertValue(int value) {
        insertNode(root,value);
    }

    public void preSearch() {
        root.preSearch();
    }

    public void middleSearch(){
        root.middleSearch();
    }

    public void lastSearch(){
        root.lastSearch();
    }

    public TreeNode preSearchNode(int value){
        return root.preSearchNode(value);
    }

    /**
     * 二叉树插入数据
     *
     * @param value 数据
     */
    public void insertNode(TreeNode node, int value) {
        // 遍历起始节点
        TreeNode e = node;

        // 右子树插入
        if (e.value < value) {
            if (e.rightNode == null) { // 右子树不存在则新建
                e.rightNode = new TreeNode(value);
            } else {
                insertNode(e.rightNode, value);
            }
        } else if (e.value > value) { // 左子树
            if (e.leftNode == null) {
                e.leftNode =  new TreeNode(value);
            } else {
                insertNode(e.leftNode, value);
            }
        } else {
            System.out.println("当前值已存在：" + value);
        }
    }


    @Data
    public class TreeNode {
        /**
         * 左节点
         */
        private TreeNode leftNode;
        /**
         * 右节点
         */
        private TreeNode rightNode;
        /**
         * 节点值
         */
        private int value;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode() {
        }

        /**
         * 先序遍历
         */
        public void preSearch() {
            // 首先输出当前节点值：
            System.out.println(this);

            // 如果左子树不为空，左子树递归先序遍历
            if (this.leftNode != null) {
                this.leftNode.preSearch();
            }

            // 如果右子树非空，右子树递归先序遍历
            if (this.rightNode != null) {
                this.rightNode.preSearch();
            }
        }

        /**
         * 中序遍历
         */
        public void middleSearch() {
            // 如果左子树不为空，左子树递归先序遍历
            if (this.leftNode != null) {
                this.leftNode.preSearch();
            }

            // 输出当前节点值：
            System.out.println(this);

            // 如果右子树非空，右子树递归先序遍历
            if (this.rightNode != null) {
                this.rightNode.preSearch();
            }
        }

        /**
         * 后序遍历
         */
        public void lastSearch() {
            // 如果左子树不为空，左子树递归先序遍历
            if (this.leftNode != null) {
                this.leftNode.preSearch();
            }

            // 如果右子树非空，右子树递归先序遍历
            if (this.rightNode != null) {
                this.rightNode.preSearch();
            }

            // 输出当前节点值：
            System.out.println(this);
        }

        /**
         * 先序搜素
         *
         * @param value 搜素值
         * @return 节点信息
         */
        public TreeNode preSearchNode(int value){
           if (this.value == value){
               return this;
           }

            // 左递归查找
            TreeNode result = null;
            if(this.leftNode != null){
                result =  this.leftNode.preSearchNode(value);
            }

            // 右递归查找
            if(result == null && this.rightNode != null){
                result =  this.rightNode.preSearchNode(value);
            }

            return result;
        }

        /**
         * 先序搜素
         *
         * @param value 搜素值
         * @return 节点信息
         */
        public TreeNode middleSearchNode(int value){
            // 左递归查找
            TreeNode result = null;
            if(this.leftNode != null){
                result =  this.leftNode.middleSearchNode(value);
            }

            if (result == null && this.value == value){
                return this;
            }

            // 右递归查找
            if(result == null && this.rightNode != null){
                result =  this.rightNode.middleSearchNode(value);
            }

            return result;
        }


        /**
         * 先序搜素
         *
         * @param value 搜素值
         * @return 节点信息
         */
        public TreeNode lastSearchNode(int value){
            // 左递归查找
            TreeNode result = null;
            if(this.leftNode != null){
                result = this.leftNode.lastSearchNode(value);
            }

            // 右递归查找
            if(result == null && this.rightNode != null){
                result =  this.rightNode.lastSearchNode(value);
            }

            if (this.value == value){
                return this;
            }

            return result;
        }


        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    '}';
        }
    }
}
