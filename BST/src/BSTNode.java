public class BSTNode{
    public int key;
    public int count;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int key){this.key=key; count=1; left=right=null;}

    public boolean delete(int x, BSTNode parent){
        if(x < this.key)
        {
            if (left != null)
                return left.delete(x,this);
            else{
                return false;
            }
        }
        else if (x > this.key)
        {
            if (right != null) return right.delete(x,this);
            else{
                return false;
            }
        }
        else
            {
            if (left != null && right != null){
                this.key = right.minx();
                right.delete(this.key,this);
            }else if (parent.left == this){
                parent.left = (left != null) ? left : right;
            }else if (parent.right == this){
                parent.right = (left != null) ? left : right;
            }
            return true;
        }
    }
    public int minx()
    {
        if (left == null)
            return key;
        else
            return left.minx();
    }
}
