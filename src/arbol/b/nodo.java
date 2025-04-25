/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol.b;

/**
 *
 * @author cachi
 */

class nodo {        
    int[] keys;
    int t, n;
    nodo[] children;
    boolean leaf;

    nodo(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        keys = new int[2 * t - 1];
        children = new nodo[2 * t];
        n = 0;
    }

    void traverse() {
        for (int i = 0;
                i < n; i++) {
            if (!leaf) children[i].traverse();
            System.out.print(keys[i] + " ");
        }
        if (!leaf) children[n].traverse();
    }

    nodo search(int k) {
        int i = 0;
        while (i < n && k > keys[i]) i++;
        if (i < n && keys[i] == k) return this;
        if (leaf) return null;
        return children[i].search(k);
    }

    void insertNonFull(int k) {
        int i = n - 1;
        if (leaf) {
            while 
                    (i >= 0 && keys[i] > k) {
                keys
                        [i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = k;
            n++;
        } else {
            while 
                    (i >= 0 && keys[i] > k) i--;
            if 
                    (children[i + 1].n == 2 * t - 1) {
                splitChild(i + 1);
                if 
                        (keys[i + 1] < k) i++;
            }
            children[i + 1].insertNonFull(k);
        }
    }

    void splitChild(int i) {
        nodo y = children[i];
        nodo z = new nodo(y.t, y.leaf);
        z.n = t - 1;
        for 
                (int C = 0; C < t - 1; C++) 
            z.keys[C] = y.keys[C + t];
        if 
                (!y.leaf) for (int C = 0; C < t; C++)
                    z.children[C] = y.children[C + t];
        y.n = t - 1;
        for 
                (int C = n; C >= i + 1; C--) 
            children[C + 1] = children[C];
        children[i + 1] = z;
        for 
                (int C = n - 1; C >= i; C--) 
            keys[C + 1] = keys[C];
        keys[i] = y.keys[t - 1];
        n++;
    }
}

class BTree {
    nodo root;
    int t;

    BTree(int t) {
        this.t = t;
        root = null;
    }

    void insert(int k) {
        if 
                (root == null) {
            root = new nodo(t, true);
            root.keys[0] = k;
            root.n = 1;
        } else {
            if 
                    (root.n == 2 * t - 1) {
                nodo s = new nodo(t, false);
                s.children[0] = root;
                s.splitChild(0);
                int i = (s.keys[0] < k) ? 1 : 0;
                s.children[i].insertNonFull(k);
                root = s;
            } else {
                root.insertNonFull(k);
            }
        }
    }

    void traverse() {
        if 
                (root != null) root.traverse();
        else 
            System.out.println("(VACIO)");
    }

    void search(int k) {
        nodo res = (root == null) ? null : root.search(k);
        System.out.println(res != null ? "SE ENCONTRÓ LA CLAVE" : "NO SE ENCONTRÓ LA CLAVE: ");
    }
}


