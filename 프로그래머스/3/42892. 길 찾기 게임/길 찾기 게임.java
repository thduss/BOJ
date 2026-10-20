import java.util.*;

class Solution {
    class Node {
        int x, y, num;
        Node left, right;

        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        // y 내림차순 (같은 y끼리는 서로 부모-자식이 아니라서 x 순서는 상관없음)
        list.sort((a, b) -> b.y - a.y);

        Node root = list.get(0);
        for (int i = 1; i < n; i++) {
            insert(root, list.get(i));
        }

        preorder(root);
        postorder(root);

        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        return answer;
    }

    void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }

    void preorder(Node node) {
        if (node == null) return;
        pre.add(node.num);
        preorder(node.left);
        preorder(node.right);
    }

    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        post.add(node.num);
    }
}