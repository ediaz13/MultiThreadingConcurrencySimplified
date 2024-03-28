package org.mogul.problem;
import java.util.ArrayList;
import java.util.*;

class File {
    private String name;
    private List<File> children;

    public File(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(File file) {
        this.children.add(file);
    }

    public List<File> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static File findParent(File root, File file1, File file2) {
        List<File> path1 = getPathToRoot(root, file1);
        List<File> path2 = getPathToRoot(root, file2);

        File commonParent = null;

        // Reverse both paths
        Collections.reverse(path1);
        Collections.reverse(path2);

        // Iterate through both paths simultaneously
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) == path2.get(i)) {
                commonParent = path1.get(i);
            } else {
                break; // Stop iterating if a mismatch is found
            }
        }

        return commonParent;
    }

    // Helper method to get the path from a file to the root
    private static List<File> getPathToRoot(File root, File file) {
        List<File> path = new ArrayList<>();
        getPathToRootChildrenHelper(root, file, path);
        return path;
    }

    // Helper method to recursively find the path from a file to the root
    private static boolean getPathToRootChildrenHelper(File root, File file, List<File> path) {
        if (root == null) {
            return false;
        }
        if (root == file || getPathToRootChildrenHelper(root.getChildren(), file, path)) {
            path.add(root);
            return true;
        }
        return false;
    }

    // Helper method to recursively find the path from a file to the root in children
    private static boolean getPathToRootChildrenHelper(List<File> children, File file, List<File> path) {
        for (File child : children) {
            if (getPathToRootChildrenHelper(child, file, path)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example input
        File root = new File("root");
        File a = new File("a");
        File b = new File("b");
        File c = new File("c");
        File d = new File("d");

        root.addChild(a);
        root.addChild(b);
        a.addChild(c);
        a.addChild(d);

        File parent1 = findParent(root, a, b);
        File parent2 = findParent(root, c, d);

        System.out.println("Common parent of a and b: " + (parent1 != null ? parent1.getName() : "None"));
        System.out.println("Common parent of c and d: " + (parent2 != null ? parent2.getName() : "None"));
    }
}