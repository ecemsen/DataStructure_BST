public class BST{
    private BSTNode root;      /* Pointer to the root of the tree */
    private int noOfNodes;     /* No of nodes in the tree */


    public BST(){root=null; noOfNodes=0;}

    public BSTNode Root(){return root;}

    public int NoOfNodes(){return calculateNodes(root);}

    public int calculateNodes(BSTNode root)
    {
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return 1;
        }
        return calculateNodes(root.left)+calculateNodes(root.right)+1;
    }

    public BSTNode Insert(int key) {
        BSTNode bst = new BSTNode(key);
        BSTNode y= null;
        BSTNode x =root;

        while (x != null)
        {
            y = x;
            if (key == x.key)
            {
                x.count++;
                noOfNodes--;
                break;
            }
            else if (key < x.key)
                x = x.left;
            else
                x = x.right;
        }

        if (root == null)
            root = bst;
        else if (key < y.key)
            y.left = bst;
        else  if(key>y.key)
            y.right = bst;

        noOfNodes++;
        return x;
    }

    public int Delete(int key)
    {
        // Fill this in
        if (root == null)
            return -1;
        else {
            if (root.key == key)
            {
                BSTNode nd = new BSTNode(0);
                nd.left = root;
                boolean result = root.delete(key,nd);
                root = nd.left;
                if (result)
                {
                    return 0;
                }
                else
                    return -1;
            }
            else if (root.delete(key, null))
            {
                return 0;
            }
            else
                {
                return -1;
            }
        }
    }

    public BSTNode Find(int key)
    {
        BSTNode r = root;

        while(r!=null)
        {
            if (key == r.key)
                return r;
            else if (key < r.key)
                r = r.left;
            else
                r = r.right;
        }
        return null;
    }

    public BSTNode Min()
    {
        BSTNode p = root;
        if (root == null)
            return null;

        while (p.left != null){
            p = p.left;
        }
        return p;
    }


    public BSTNode Max()
    {
        BSTNode p = root;
        if (root == null)
            return null;

        while (p.right != null){
            p = p.right;
        }
        return p;
    }

    public int Depth()
    {
        return calculateDepth(root);
    }

    public int calculateDepth(BSTNode p) {
        if (p == null)
        {
            return (-1);
        }
        else
            {
            int leftDepth = calculateDepth(p.left);
            int rightDepth = calculateDepth(p.right);
            if (leftDepth > rightDepth )
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    public void Print()
    {
        printInorder(root);
    }
    public void printInorder(BSTNode root)
    {
        if (root == null) return;
        printInorder(root.left);
        System.out.println("  "+root.key+", "+root.count+"  ");
        printInorder(root.right);
    }
}



