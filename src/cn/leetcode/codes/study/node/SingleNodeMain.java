package cn.leetcode.codes.study.node;


/*

单链表操作
 */
public class SingleNodeMain {


    public static void main(String[] args){


        LiNode liNode = new LiNode(0);
        liNode.addLastNode(new LiNode(1));
        liNode.addLastNode(new LiNode(2));
        liNode.addLastNode(new LiNode(3));

        LiNode node4 = new LiNode(4);
        liNode.addLastNode(node4);
        liNode.addLastNode(new LiNode(5));


        System.out.println(" liNode = "+liNode);
        liNode.removeNode(node4);

        System.out.println(" liNode = "+liNode);

        // 获取第二个节点数据
        LiNode reNode = liNode.getNode(2);

        System.out.print("reNode = "+reNode);

//        printLiNode(liNode);


    }


    static void printLiNode(LiNode node){
        LiNode curr = node;
        while (curr.next != null){
            System.out.println(" curr = "+curr);

            curr = curr.next;
        }
    }



}


class LiNode{

    public int val;
    public LiNode next;

    public LiNode(int v){
        this.val = v;

        this.mSize = 1;
    }

    private transient int mSize;


    /**
     *
     * 添加首个节点
     *
     * @param node 节点
     */
    public void addFirstLiNode(LiNode node) {




    }


    /**
     *
     * 在末尾添加节点
     *
     * @param node 节点数据
     */
    public void addLastNode(LiNode node){

        // 移动节点
        LiNode curr = this;
        while (curr.next != null){
            curr = curr.next;
        }
        // 添加到末尾
        curr.next = node;

        this.mSize++;

    }

    /**
     *
     * 删除一个节点
     *
     * @param node 节点数据
     */
    public void removeNode(LiNode node){

        LiNode curr = this;
        //要删除的 下一个节点
        LiNode nextNode = null;

        while (curr.next != null){
            // 找到要删除的节点
            if (curr.val == node.val){
                nextNode = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        curr.next = nextNode;

        this.mSize--;
    }

    /**
     *
     * 修改一个节点
     *
     * @param node 节点数据
     */
    public void updateNode(LiNode node){

        LiNode curr = this;
        do {
            if (curr.val == node.val){

            }
        } while (curr.next != null);


    }


    /**
     *
     * 获取指定节点数据
     *
     * @param index 节点索引
     * @return 节点数据 or null
     */
    public LiNode getNode(int index){
        int count = 0;
        LiNode curr = this;
        while (curr.next != null){
            if (count == index){
                return curr;
            }
            curr = curr.next;
            count++;
        }
        return null;
    }


    public int size(){
        return mSize;
    }



    @Override
    public String toString() {
        return "LiNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}



