package leetcode;

public class L208 {
    class Trie {
        Trie[] children;

        boolean isEnd = false;

        public Trie() {
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie root = this;
            char[] chars = word.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                int index = chars[i] - 'a';
                if (root.children[index] == null) {
                    root.children[index] = new Trie();
                }
                root = root.children[index];
            }
            root.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = starts(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return starts(prefix) != null;
        }

        private Trie starts(String word) {
            Trie root = this;
            char[] chars = word.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                int index = chars[i] - 'a';
                if (root.children[index] == null) {
                    return null;
                }
                root = root.children[index];
            }
            return root;
        }
    }
}
