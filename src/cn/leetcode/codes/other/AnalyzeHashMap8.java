//package cn.leetcode.codes.other;
//
//import java.io.IOException;
//import java.io.InvalidObjectException;
//import java.io.Serializable;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.*;
//import java.util.function.BiConsumer;
//import java.util.function.BiFunction;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
///**
// *
// * 主要分析Java 8 hashMap 源码分析 copy进行分析
// *
// * @param <K>
// * @param <V>
// */
//public class AnalyzeHashMap8<K, V> extends AbstractMap<K, V>
//        implements Map<K, V>, Cloneable, Serializable {
//
//    private static final long serialVersionUID = 362498820763181265L;
//
//
//
//    /**
//     * 默认HashMap容量大小 16
//     */
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
//
//    /**
//     * HashMap 最大容量 1073741824
//     */
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//
//    /**
//     *
//     * 默认负载因子
//     *
//     * 默认负载因子是0.75是两个原因：
//     * 1.容量和性能平衡的结果一个科学计算出来的值
//     * 2.为了保证HashMap容量2的幂 (容量 * 负载因子)如果负载因子是 3/4 结果刚好是一个整数
//     *
//     */
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//
//    /**
//     *
//     * 链表长度大于此值且 容量大于 64 时会将链表转换成红黑树表示
//     */
//    static final int TREEIFY_THRESHOLD = 8;
//
//    /**
//     * 红黑树转换成链表时阈值 如果红黑树长度小于6 会转换成 链表表示
//     */
//    static final int UNTREEIFY_THRESHOLD = 6;
//
//    /**
//     *红黑树最小容量
//     */
//    static final int MIN_TREEIFY_CAPACITY = 64;
//
//    /**
//     * Basic hash bin node, used for most entries.  (See below for
//     * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
//     */
//    static class Node<K, V> implements Map.Entry<K, V> {
//        // hash 值
//        final int hash;
//        final K key;
//        V value;
//        // 后继指针
//        Node<K, V> next;
//
//        Node(int hash, K key, V value, Node<K, V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        public final K getKey() {
//            return key;
//        }
//
//        public final V getValue() {
//            return value;
//        }
//
//        public final String toString() {
//            return key + "=" + value;
//        }
//
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        public final boolean equals(Object o) {
//            if (o == this)
//                return true;
//            if (o instanceof Map.Entry) {
//                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
//                if (Objects.equals(key, e.getKey()) &&
//                        Objects.equals(value, e.getValue()))
//                    return true;
//            }
//            return false;
//        }
//    }
//
//    /* ---------------- Static utilities -------------- */
//
//    /**
//     * Computes key.hashCode() and spreads (XORs) higher bits of hash
//     * to lower.  Because the table uses power-of-two masking, sets of
//     * hashes that vary only in bits above the current mask will
//     * always collide. (Among known examples are sets of Float keys
//     * holding consecutive whole numbers in small tables.)  So we
//     * apply a transform that spreads the impact of higher bits
//     * downward. There is a tradeoff between speed, utility, and
//     * quality of bit-spreading. Because many common sets of hashes
//     * are already reasonably distributed (so don't benefit from
//     * spreading), and because we use trees to handle large sets of
//     * collisions in bins, we just XOR some shifted bits in the
//     * cheapest possible way to reduce systematic lossage, as well as
//     * to incorporate impact of the highest bits that would otherwise
//     * never be used in index calculations because of table bounds.
//     *
//     * 计算 K 的 hashCode() 值
//     *优化了高位运算的算法，通过hashCode()的高16位异或低16位实现的：(h = k.hashCode()) ^ (h >>> 16)，主要是从速度、功效、质量来考虑的。以上方法得到的int的hash值，然后再通过h & (table.length -1)来得到该对象在数据中保存的位置。
//     */
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//
//
//    /**
//     * Returns x's Class if it is of the form "class C implements
//     * Comparable<C>", else null.
//     */
//    static Class<?> comparableClassFor(Object x) {
//        if (x instanceof Comparable) {
//            Class<?> c;
//            Type[] ts, as;
//            Type t;
//            ParameterizedType p;
//            if ((c = x.getClass()) == String.class) // bypass checks
//                return c;
//            if ((ts = c.getGenericInterfaces()) != null) {
//                for (int i = 0; i < ts.length; ++i) {
//                    if (((t = ts[i]) instanceof ParameterizedType) &&
//                            ((p = (ParameterizedType) t).getRawType() ==
//                                    Comparable.class) &&
//                            (as = p.getActualTypeArguments()) != null &&
//                            as.length == 1 && as[0] == c) // type arg is c
//                        return c;
//                }
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Returns k.compareTo(x) if x matches kc (k's screened comparable
//     * class), else 0.
//     */
//    @SuppressWarnings({"rawtypes", "unchecked"}) // for cast to Comparable
//    static int compareComparables(Class<?> kc, Object k, Object x) {
//        return (x == null || x.getClass() != kc ? 0 :
//                ((Comparable) k).compareTo(x));
//    }
//
//    /**
//     * 对于给定大小 返回 2的幂 大小
//     */
//    static final int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
//
//    /* ---------------- Fields -------------- */
//
//    /**
//     * The table, initialized on first use, and resized as
//     * necessary. When allocated, length is always a power of two.
//     * (We also tolerate length zero in some operations to allow
//     * bootstrapping mechanics that are currently not needed.)
//     *
//     * 第一次初始化的数据表，在扩容时长度总是保证 2的幂
//     */
//    transient Node<K, V>[] table;
//
//    /**
//     * Holds cached entrySet(). Note that AbstractMap fields are used
//     * for keySet() and values().
//     *
//     * 转换成set集合
//     *
//     */
//    transient Set<Map.Entry<K, V>> entrySet;
//
//    /**
//     * The number of key-value mappings contained in this map.
//     *
//     * map集合的大小
//     */
//    transient int size;
//
//    /**
//     * The number of times this HashMap has been structurally modified
//     * Structural modifications are those that change the number of mappings in
//     * the HashMap or otherwise modify its internal structure (e.g.,
//     * rehash).  This field is used to make iterators on Collection-views of
//     * the HashMap fail-fast.  (See ConcurrentModificationException).
//     *
//     * 此哈希映射在结构上被修改的次数
//     * 哈希映射或以其他方式修改其内部结构（例如。，
//     * 重新整理）。此字段用于对的集合视图生成迭代器遍历 fail-fast 机制 否则会抛出 ConcurrentModificationException 异常
//     *
//     */
//    transient int modCount;
//
//    /**
//     * The next size value at which to resize (capacity * load factor).
//     *
//     * 下一次需要调整的大小 （容量 * 负载因子）
//     *
//     * @serial
//     */
//    // (The javadoc description is true upon serialization.
//    // Additionally, if the table array has not been allocated, this
//    // field holds the initial array capacity, or zero signifying
//    // DEFAULT_INITIAL_CAPACITY.)
//    int threshold;
//
//    /**
//     * The load factor for the hash table.
//     *
//     * 负载因子
//     * @serial
//     */
//    final float loadFactor;
//
//    /* ---------------- Public operations -------------- */
//
//    /**
//     * Constructs an empty <tt>HashMap</tt> with the specified initial
//     * capacity and load factor.
//     *
//     * 可以指定初始HashMap的大小 和 负载因子
//     *
//     * @param initialCapacity the initial capacity
//     * @param loadFactor      the load factor
//     * @throws IllegalArgumentException if the initial capacity is negative
//     *                                  or the load factor is nonpositive
//     */
//    public AnalyzeHashMap8(int initialCapacity, float loadFactor) {
//        if (initialCapacity < 0)
//            throw new IllegalArgumentException("Illegal initial capacity: " +
//                    initialCapacity);
//        if (initialCapacity > MAXIMUM_CAPACITY)
//            initialCapacity = MAXIMUM_CAPACITY;
//        if (loadFactor <= 0 || Float.isNaN(loadFactor))
//            throw new IllegalArgumentException("Illegal load factor: " +
//                    loadFactor);
//        this.loadFactor = loadFactor;
//        this.threshold = tableSizeFor(initialCapacity);
//    }
//
//    /**
//     * Constructs an empty <tt>HashMap</tt> with the specified initial
//     * capacity and the default load factor (0.75).
//     *
//     * @param initialCapacity the initial capacity.
//     * @throws IllegalArgumentException if the initial capacity is negative.
//     */
//    public AnalyzeHashMap8(int initialCapacity) {
//        this(initialCapacity, DEFAULT_LOAD_FACTOR);
//    }
//
//    /**
//     * Constructs an empty <tt>HashMap</tt> with the default initial capacity
//     * (16) and the default load factor (0.75).
//     */
//    public AnalyzeHashMap8() {
//        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
//    }
//
//    /**
//     * Constructs a new <tt>HashMap</tt> with the same mappings as the
//     * specified <tt>Map</tt>.  The <tt>HashMap</tt> is created with
//     * default load factor (0.75) and an initial capacity sufficient to
//     * hold the mappings in the specified <tt>Map</tt>.
//     *
//     * @param m the map whose mappings are to be placed in this map
//     * @throws NullPointerException if the specified map is null
//     */
//    public AnalyzeHashMap8(Map<? extends K, ? extends V> m) {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//        putMapEntries(m, false);
//    }
//
//    /**
//     * Implements Map.putAll and Map constructor
//     *
//     * 直接添加整个Map集合
//     *
//     * @param m     the map
//     * @param evict false when initially constructing this map, else
//     *              true (relayed to method afterNodeInsertion).
//     */
//    final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
//        //map大小
//        int s = m.size();
//        //只有map大小 大于 0 才进行添加
//        if (s > 0) {
//            // 如果原始数组为 null
//            if (table == null) { // pre-size
//                float ft = ((float) s / loadFactor) + 1.0F;
//                int t = ((ft < (float) MAXIMUM_CAPACITY) ?
//                        (int) ft : MAXIMUM_CAPACITY);
//                if (t > threshold)
//                    threshold = tableSizeFor(t);
//            } else if (s > threshold)       //扩容
//                resize();
//            //循环遍历插入数据中
//            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
//                K key = e.getKey();
//                V value = e.getValue();
//                putVal(hash(key), key, value, false, evict);
//            }
//        }
//    }
//
//    /**
//     * Returns the number of key-value mappings in this map.
//     *
//     * @return the number of key-value mappings in this map
//     *
//     * 大小
//     */
//    public int size() {
//        return size;
//    }
//
//    /**
//     * Returns <tt>true</tt> if this map contains no key-value mappings.
//     *
//     * @return <tt>true</tt> if this map contains no key-value mappings
//     *
//     * 是否为 空
//     */
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    /**
//     * Returns the value to which the specified key is mapped,
//     * or {@code null} if this map contains no mapping for the key.
//     *
//     * <p>More formally, if this map contains a mapping from a key
//     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
//     * key.equals(k))}, then this method returns {@code v}; otherwise
//     * it returns {@code null}.  (There can be at most one such mapping.)
//     *
//     * <p>A return value of {@code null} does not <i>necessarily</i>
//     * indicate that the map contains no mapping for the key; it's also
//     * possible that the map explicitly maps the key to {@code null}.
//     * The {@link #containsKey containsKey} operation may be used to
//     * distinguish these two cases.
//     *
//     * @see #put(Object, Object)
//     *
//     * 先对key 进行 hash() 的hash值进行查找桶的位置
//     */
//    public V get(Object key) {
//        Node<K, V> e;
//        // 得到一个节点，之后从节点中查找value
//        return (e = getNode(hash(key), key)) == null ? null : e.value;
//    }
//
//    /**
//     * Implements Map.get and related methods
//     *
//     * 获取HashMap上节点数据
//     *
//     * @param hash hash for key
//     * @param key  the key
//     * @return the node, or null if none
//     */
//    final Node<K, V> getNode(int hash, Object key) {
//        // 临时数组
//        Node<K, V>[] tab;
//        // 第一个节点 、要查找的节点
//        Node<K, V> first, e;
//        // 数组长度
//        int n;
//        K k;
//        // 当前数组 != null 且 数组长度大于 0 且 第一个节点不等于null
//        if ((tab = table) != null && (n = tab.length) > 0 &&
//                (first = tab[(n - 1) & hash]) != null) {
//            // 要查找的值 正好是第一个节点 一次就命中
//            //最好情况时间复杂度是 O(1)
//            if (first.hash == hash && // always check first node
//                    ((k = first.key) == key || (key != null && key.equals(k))))
//                return first;
//            // 要查找的值 不是第一个节点
//            if ((e = first.next) != null) {
//                // 如果是红黑树节点 则调用 getTreeNode() 来获取
//                // 时间复杂度O(log n)
//                if (first instanceof TreeNode)
//                    return ((TreeNode<K, V>) first).getTreeNode(hash, key);
//                // 链表表示 循环匹配
//                // 最坏情况下 时间复杂度O(n)
//                do {
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        return e;
//                } while ((e = e.next) != null);
//            }
//        }
//        // 不满足上述条件 直接返回null
//        return null;
//    }
//
//    /**
//     * Returns <tt>true</tt> if this map contains a mapping for the
//     * specified key.
//     *
//     * @param key The key whose presence in this map is to be tested
//     * @return <tt>true</tt> if this map contains a mapping for the specified
//     * key.
//     *
//     * 判断是否存在key值
//     */
//    public boolean containsKey(Object key) {
//        return getNode(hash(key), key) != null;
//    }
//
//    /**
//     * Associates the specified value with the specified key in this map.
//     * If the map previously contained a mapping for the key, the old
//     * value is replaced.
//     *
//     * @param key   key with which the specified value is to be associated
//     * @param value value to be associated with the specified key
//     * @return the previous value associated with <tt>key</tt>, or
//     * <tt>null</tt> if there was no mapping for <tt>key</tt>.
//     * (A <tt>null</tt> return can also indicate that the map
//     * previously associated <tt>null</tt> with <tt>key</tt>.)
//     *
//     * 添加元素
//     * 首先对key 进行hash() 操作
//     */
//    public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//    }
//
//    /**
//     * Implements Map.put and related methods
//     *
//     * @param hash         hash for key
//     * @param key          the key
//     * @param value        the value to put
//     * @param onlyIfAbsent if true, don't change existing value
//     * @param evict        if false, the table is in creation mode.
//     * @return previous value, or null if none
//     *
//     * 添加元素具体实现方法
//     */
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        // 临时数组
//        Node<K, V>[] tab;
//        Node<K, V> p;
//        //数组长度、
//        int n, i;
//        // 如果此时table数组为null或长度为0 则进行一次扩容
//        if ((tab = table) == null || (n = tab.length) == 0)
//            //进行一次扩容
//            n = (tab = resize()).length;
//        //根据key的hash值 确定要插入的数组索引
//        if ((p = tab[i = (n - 1) & hash]) == null)
//            //如果tab[i] == null 则直接在尾部插入一个新节点
//            tab[i] = newNode(hash, key, value, null);
//        else {
//            Node<K, V> e;
//            K k;
//            //如果key值已经存在则直接覆盖value
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;
//            //key 不存在则判断是否是 红黑树 直接插入红黑树中
//            else if (p instanceof TreeNode)
//                e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
//            else {
//                //链表结构 循环准备插入
//                for (int binCount = 0; ; ++binCount) {
//                    //找到next 后继指针为 null 的链表节点 准备插入
//                    if ((e = p.next) == null) {
//                        //添加链表节点
//                        p.next = newNode(hash, key, value, null);
//                        // 链表长度大于 8 将链表转换成 红黑树
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    //key值存在覆盖 value
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            //存在相同的 key 使用新值替代旧值 返回旧值
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        //操作次数增加
//        ++modCount;
//        //如果大小 大于扩容阈值 进行扩容
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//
//    /**
//     * Initializes or doubles table size.  If null, allocates in
//     * accord with initial capacity target held in field threshold.
//     * Otherwise, because we are using power-of-two expansion, the
//     * elements from each bin must either stay at same index, or move
//     * with a power of two offset in the new table.
//     *
//     * 初始化或扩容表大小。如果为空，则分配与初始容量目标保持一致。否则，因为我们使用的是2的幂，所以
//     * 每个bin中的元素必须保持在同一索引中，或者移动在新表中使用两个偏移量的幂。
//     *
//     * @return the table
//     */
//    final Node<K, V>[] resize() {
//        // 旧数组
//        Node<K, V>[] oldTab = table;
//
//        // 旧的数组长度
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        //旧 容器达到扩容阈值
//        int oldThr = threshold;
//        // 新的数组大小、新下一次达到扩容阈值大小
//        int newCap, newThr = 0;
//        if (oldCap > 0) {
//            // 如果大于最大的容量 不进行扩容 直接返回旧 table
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
//                    oldCap >= DEFAULT_INITIAL_CAPACITY)
//                newThr = oldThr << 1; // double threshold 扩容为原来 2倍
//        } else if (oldThr > 0) // initial capacity was placed in threshold  当前数组没有数据，使用初始化的值
//            newCap = oldThr;   // 将下一次扩容阈值 和 新数组大小设置为一样值
//        else {               // zero initial threshold signifies using defaults  初始化大小
//            newCap = DEFAULT_INITIAL_CAPACITY;  // 16 默认数组大小
//            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); // 12 = 0.75*16  默认下次达到扩容的阈值
//        }
//        // 如果新的达到扩容阈值为 0 则重新计算下次扩容阈值
//        if (newThr == 0) {
//            float ft = (float) newCap * loadFactor;
//            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ?
//                    (int) ft : Integer.MAX_VALUE);
//        }
//        // 将局部数据 同步至全局数据
//        threshold = newThr;
//        //直接创建一个新的数组
//        @SuppressWarnings({"rawtypes", "unchecked"})
//        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
//        //将局部数据同步至全局数据
//        table = newTab;
//
//        //从旧数组copy数据到 新数组中
//        if (oldTab != null) {
//            for (int j = 0; j < oldCap; ++j) {
//                Node<K, V> e;
//                if ((e = oldTab[j]) != null) {
//                    oldTab[j] = null;
//                    if (e.next == null)  //如果链表只有一个 则直接插入
//                        newTab[e.hash & (newCap - 1)] = e;
//                    else if (e instanceof TreeNode) //处理红黑树数据
//                        ((TreeNode<K, V>) e).split(this, newTab, j, oldCap);
//                    else { // preserve order
//                        //链表复制 JDK 1.8 优化
//                        Node<K, V> loHead = null, loTail = null;
//                        Node<K, V> hiHead = null, hiTail = null;
//                        Node<K, V> next;
//                        do {
//                            next = e.next;
//                            //原索引
//                            if ((e.hash & oldCap) == 0) {
//                                if (loTail == null)
//                                    loHead = e;
//                                else
//                                    loTail.next = e;
//                                loTail = e;
//                            } else {  //原索引 + oldCap
//                                if (hiTail == null)
//                                    hiHead = e;
//                                else
//                                    hiTail.next = e;
//                                hiTail = e;
//                            }
//                        } while ((e = next) != null);
//                        //将原索引直接放入hash桶中
//                        if (loTail != null) {
//                            loTail.next = null;
//                            newTab[j] = loHead;
//                        }
//                        //将原索引+oldCap 放入哈希桶中
//                        if (hiTail != null) {
//                            hiTail.next = null;
//                            newTab[j + oldCap] = hiHead;
//                        }
//                    }
//                }
//            }
//        }
//        //返回新数组
//        return newTab;
//    }
//
//    /**
//     * Replaces all linked nodes in bin at index for given hash unless
//     * table is too small, in which case resizes instead.
//     */
//    final void treeifyBin(Node<K, V>[] tab, int hash) {
//        int n, index;
//        Node<K, V> e;
//        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
//            //扩容
//            resize();
//        else if ((e = tab[index = (n - 1) & hash]) != null) {
//            TreeNode<K, V> hd = null, tl = null;
//            do {
//                //将链表转换成 红黑树节点
//                TreeNode<K, V> p = replacementTreeNode(e, null);
//                if (tl == null)
//                    hd = p;
//                else {
//                    p.prev = tl;
//                    tl.next = p;
//                }
//                tl = p;
//            } while ((e = e.next) != null);
//            if ((tab[index] = hd) != null)
//                hd.treeify(tab);
//        }
//    }
//
//    /**
//     * Copies all of the mappings from the specified map to this map.
//     * These mappings will replace any mappings that this map had for
//     * any of the keys currently in the specified map.
//     *
//     * @param m mappings to be stored in this map
//     * @throws NullPointerException if the specified map is null
//     *
//     * 添加所有 map 数据
//     */
//    public void putAll(Map<? extends K, ? extends V> m) {
//        putMapEntries(m, true);
//    }
//
//    /**
//     * Removes the mapping for the specified key from this map if present.
//     *
//     * @param key key whose mapping is to be removed from the map
//     * @return the previous value associated with <tt>key</tt>, or
//     * <tt>null</tt> if there was no mapping for <tt>key</tt>.
//     * (A <tt>null</tt> return can also indicate that the map
//     * previously associated <tt>null</tt> with <tt>key</tt>.)
//     *
//     * 移除一个数据
//     *
//     */
//    public V remove(Object key) {
//        Node<K, V> e;
//        return (e = removeNode(hash(key), key, null, false, true)) == null ?
//                null : e.value;
//    }
//
//    /**
//     * Implements Map.remove and related methods
//     *
//     * @param hash       hash for key
//     * @param key        the key
//     * @param value      the value to match if matchValue, else ignored
//     * @param matchValue if true only remove if value is equal
//     * @param movable    if false do not move other nodes while removing
//     * @return the node, or null if none
//     */
//    final Node<K, V> removeNode(int hash, Object key, Object value,
//                                                  boolean matchValue, boolean movable) {
//        //原数组
//        Node<K, V>[] tab;
//        Node<K, V> p;
//        int n, index;
//
//        //数组不为空 且 和最后一个数据不相同
//        if ((tab = table) != null && (n = tab.length) > 0 &&
//                (p = tab[index = (n - 1) & hash]) != null) {
//            Node<K, V> node = null, e;
//            K k;
//            V v;
//            // 确定索引位置
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k))))
//                node = p;
//            else if ((e = p.next) != null) {
//                // 处理红黑树
//                if (p instanceof TreeNode)
//                    node = ((TreeNode<K, V>) p).getTreeNode(hash, key);
//                else {
//                    //处理链表删除
//                    do {
//                        if (e.hash == hash &&
//                                ((k = e.key) == key ||
//                                        (key != null && key.equals(k)))) {
//                            node = e;
//                            break;
//                        }
//                        p = e;
//                    } while ((e = e.next) != null);
//                }
//            }
//            if (node != null && (!matchValue || (v = node.value) == value ||
//                    (value != null && value.equals(v)))) {
//                if (node instanceof TreeNode)
//                    ((TreeNode<K, V>) node).removeTreeNode(this, tab, movable);
//                else if (node == p)
//                    tab[index] = node.next;
//                else
//                    p.next = node.next;
//                //操作数量增加
//                ++modCount;
//                //数量减少
//                --size;
//                afterNodeRemoval(node);
//                return node;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Removes all of the mappings from this map.
//     * The map will be empty after this call returns.
//     *
//     * 清除所有数据
//     */
//    public void clear() {
//        Node<K, V>[] tab;
//        modCount++;
//        if ((tab = table) != null && size > 0) {
//            size = 0;
//            for (int i = 0; i < tab.length; ++i)
//                tab[i] = null;
//        }
//    }
//
//    /**
//     * Returns <tt>true</tt> if this map maps one or more keys to the
//     * specified value.
//     *
//     * @param value value whose presence in this map is to be tested
//     * @return <tt>true</tt> if this map maps one or more keys to the
//     * specified value
//     *
//     * 判断是否含有此 value
//     */
//    public boolean containsValue(Object value) {
//        Node<K, V>[] tab;
//        V v;
//        if ((tab = table) != null && size > 0) {
//            for (int i = 0; i < tab.length; ++i) {
//                for (Node<K, V> e = tab[i]; e != null; e = e.next) {
//                    if ((v = e.value) == value ||
//                            (value != null && value.equals(v)))
//                        return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     * Returns a {@link Set} view of the keys contained in this map.
//     * The set is backed by the map, so changes to the map are
//     * reflected in the set, and vice-versa.  If the map is modified
//     * while an iteration over the set is in progress (except through
//     * the iterator's own <tt>remove</tt> operation), the results of
//     * the iteration are undefined.  The set supports element removal,
//     * which removes the corresponding mapping from the map, via the
//     * <tt>Iterator.remove</tt>, <tt>Set.remove</tt>,
//     * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
//     * operations.  It does not support the <tt>add</tt> or <tt>addAll</tt>
//     * operations.
//     *
//     * @return a set view of the keys contained in this map
//     *
//     * 得到Set<K>集合
//     */
//    public Set<K> keySet() {
//        Set<K> ks = keySet;
//        if (ks == null) {
//            ks = new KeySet();
//            keySet = ks;
//        }
//        return ks;
//    }
//
//    final class KeySet extends AbstractSet<K> {
//        public final int size() {
//            return size;
//        }
//
//        public final void clear() {
//            this.clear();
//        }
//
//        public final Iterator<K> iterator() {
//            return new KeyIterator();
//        }
//
//        public final boolean contains(Object o) {
//            return containsKey(o);
//        }
//
//        public final boolean remove(Object key) {
//            return removeNode(hash(key), key, null, false, true) != null;
//        }
//
//        public final Spliterator<K> spliterator() {
//            return new KeySpliterator<>(this, 0, -1, 0, 0);
//        }
//
//        public final void forEach(Consumer<? super K> action) {
//            Node<K, V>[] tab;
//            if (action == null)
//                throw new NullPointerException();
//            if (size > 0 && (tab = table) != null) {
//                int mc = modCount;
//                for (int i = 0; i < tab.length; ++i) {
//                    for (Node<K, V> e = tab[i]; e != null; e = e.next)
//                        action.accept(e.key);
//                }
//                if (modCount != mc)
//                    throw new ConcurrentModificationException();
//            }
//        }
//    }
//
//    /**
//     * Returns a {@link Collection} view of the values contained in this map.
//     * The collection is backed by the map, so changes to the map are
//     * reflected in the collection, and vice-versa.  If the map is
//     * modified while an iteration over the collection is in progress
//     * (except through the iterator's own <tt>remove</tt> operation),
//     * the results of the iteration are undefined.  The collection
//     * supports element removal, which removes the corresponding
//     * mapping from the map, via the <tt>Iterator.remove</tt>,
//     * <tt>Collection.remove</tt>, <tt>removeAll</tt>,
//     * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
//     * support the <tt>add</tt> or <tt>addAll</tt> operations.
//     *
//     * @return a view of the values contained in this map
//     *
//     * 得到所有value 数据
//     */
//    public Collection<V> values() {
//        Collection<V> vs = values;
//        if (vs == null) {
//            vs = new Values();
//            values = vs;
//        }
//        return vs;
//    }
//
//    final class Values extends AbstractCollection<V> {
//        public final int size() {
//            return size;
//        }
//
//        public final void clear() {
//            this.clear();
//        }
//
//        public final Iterator<V> iterator() {
//            return new ValueIterator();
//        }
//
//        public final boolean contains(Object o) {
//            return containsValue(o);
//        }
//
//        public final Spliterator<V> spliterator() {
//            return new ValueSpliterator<>(this, 0, -1, 0, 0);
//        }
//
//        public final void forEach(Consumer<? super V> action) {
//            Node<K, V>[] tab;
//            if (action == null)
//                throw new NullPointerException();
//            if (size > 0 && (tab = table) != null) {
//                int mc = modCount;
//                for (int i = 0; i < tab.length; ++i) {
//                    for (Node<K, V> e = tab[i]; e != null; e = e.next)
//                        action.accept(e.value);
//                }
//                if (modCount != mc)
//                    throw new ConcurrentModificationException();
//            }
//        }
//    }
//
//    /**
//     * Returns a {@link Set} view of the mappings contained in this map.
//     * The set is backed by the map, so changes to the map are
//     * reflected in the set, and vice-versa.  If the map is modified
//     * while an iteration over the set is in progress (except through
//     * the iterator's own <tt>remove</tt> operation, or through the
//     * <tt>setValue</tt> operation on a map entry returned by the
//     * iterator) the results of the iteration are undefined.  The set
//     * supports element removal, which removes the corresponding
//     * mapping from the map, via the <tt>Iterator.remove</tt>,
//     * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and
//     * <tt>clear</tt> operations.  It does not support the
//     * <tt>add</tt> or <tt>addAll</tt> operations.
//     *
//     * @return a set view of the mappings contained in this map
//     */
//    public Set<Map.Entry<K, V>> entrySet() {
//        Set<Map.Entry<K, V>> es;
//        return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
//    }
//
//    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
//        public final int size() {
//            return size;
//        }
//
//        public final void clear() {
//            this.clear();
//        }
//
//        public final Iterator<Map.Entry<K, V>> iterator() {
//            return new EntryIterator();
//        }
//
//        public final boolean contains(Object o) {
//            if (!(o instanceof Map.Entry))
//                return false;
//            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
//            Object key = e.getKey();
//            Node<K, V> candidate = getNode(hash(key), key);
//            return candidate != null && candidate.equals(e);
//        }
//
//        public final boolean remove(Object o) {
//            if (o instanceof Map.Entry) {
//                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
//                Object key = e.getKey();
//                Object value = e.getValue();
//                return removeNode(hash(key), key, value, true, true) != null;
//            }
//            return false;
//        }
//
//        public final Spliterator<Map.Entry<K, V>> spliterator() {
//            return new EntrySpliterator<>(this, 0, -1, 0, 0);
//        }
//
//        public final void forEach(Consumer<? super Map.Entry<K, V>> action) {
//            Node<K, V>[] tab;
//            if (action == null)
//                throw new NullPointerException();
//            if (size > 0 && (tab = table) != null) {
//                int mc = modCount;
//                for (int i = 0; i < tab.length; ++i) {
//                    for (Node<K, V> e = tab[i]; e != null; e = e.next)
//                        action.accept(e);
//                }
//                if (modCount != mc)
//                    throw new ConcurrentModificationException();
//            }
//        }
//    }
//
//    // Overrides of JDK8 Map extension methods
//
//    @Override
//    public V getOrDefault(Object key, V defaultValue) {
//        Node<K, V> e;
//        return (e = getNode(hash(key), key)) == null ? defaultValue : e.value;
//    }
//
//    @Override
//    public V putIfAbsent(K key, V value) {
//        return putVal(hash(key), key, value, true, true);
//    }
//
//    @Override
//    public boolean remove(Object key, Object value) {
//        return removeNode(hash(key), key, value, true, true) != null;
//    }
//
//    @Override
//    public boolean replace(K key, V oldValue, V newValue) {
//        Node<K, V> e;
//        V v;
//        if ((e = getNode(hash(key), key)) != null &&
//                ((v = e.value) == oldValue || (v != null && v.equals(oldValue)))) {
//            e.value = newValue;
//            afterNodeAccess(e);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public V replace(K key, V value) {
//        Node<K, V> e;
//        if ((e = getNode(hash(key), key)) != null) {
//            V oldValue = e.value;
//            e.value = value;
//            afterNodeAccess(e);
//            return oldValue;
//        }
//        return null;
//    }
//
//    @Override
//    public V computeIfAbsent(K key,
//                             Function<? super K, ? extends V> mappingFunction) {
//        if (mappingFunction == null)
//            throw new NullPointerException();
//        int hash = hash(key);
//        Node<K, V>[] tab;
//        Node<K, V> first;
//        int n, i;
//        int binCount = 0;
//        TreeNode<K, V> t = null;
//        Node<K, V> old = null;
//        if (size > threshold || (tab = table) == null ||
//                (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        if ((first = tab[i = (n - 1) & hash]) != null) {
//            if (first instanceof TreeNode)
//                old = (t = (TreeNode<K, V>) first).getTreeNode(hash, key);
//            else {
//                Node<K, V> e = first;
//                K k;
//                do {
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k)))) {
//                        old = e;
//                        break;
//                    }
//                    ++binCount;
//                } while ((e = e.next) != null);
//            }
//            V oldValue;
//            if (old != null && (oldValue = old.value) != null) {
//                afterNodeAccess(old);
//                return oldValue;
//            }
//        }
//        V v = mappingFunction.apply(key);
//        if (v == null) {
//            return null;
//        } else if (old != null) {
//            old.value = v;
//            afterNodeAccess(old);
//            return v;
//        } else if (t != null)
//            t.putTreeVal(this, tab, hash, key, v);
//        else {
//            tab[i] = newNode(hash, key, v, first);
//            if (binCount >= TREEIFY_THRESHOLD - 1)
//                treeifyBin(tab, hash);
//        }
//        ++modCount;
//        ++size;
//        afterNodeInsertion(true);
//        return v;
//    }
//
//    public V computeIfPresent(K key,
//                              BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
//        if (remappingFunction == null)
//            throw new NullPointerException();
//        Node<K, V> e;
//        V oldValue;
//        int hash = hash(key);
//        if ((e = getNode(hash, key)) != null &&
//                (oldValue = e.value) != null) {
//            V v = remappingFunction.apply(key, oldValue);
//            if (v != null) {
//                e.value = v;
//                afterNodeAccess(e);
//                return v;
//            } else
//                removeNode(hash, key, null, false, true);
//        }
//        return null;
//    }
//
//    @Override
//    public V compute(K key,
//                     BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
//        if (remappingFunction == null)
//            throw new NullPointerException();
//        int hash = hash(key);
//        Node<K, V>[] tab;
//        Node<K, V> first;
//        int n, i;
//        int binCount = 0;
//        TreeNode<K, V> t = null;
//        Node<K, V> old = null;
//        if (size > threshold || (tab = table) == null ||
//                (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        if ((first = tab[i = (n - 1) & hash]) != null) {
//            if (first instanceof TreeNode)
//                old = (t = (TreeNode<K, V>) first).getTreeNode(hash, key);
//            else {
//                Node<K, V> e = first;
//                K k;
//                do {
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k)))) {
//                        old = e;
//                        break;
//                    }
//                    ++binCount;
//                } while ((e = e.next) != null);
//            }
//        }
//        V oldValue = (old == null) ? null : old.value;
//        V v = remappingFunction.apply(key, oldValue);
//        if (old != null) {
//            if (v != null) {
//                old.value = v;
//                afterNodeAccess(old);
//            } else
//                removeNode(hash, key, null, false, true);
//        } else if (v != null) {
//            if (t != null)
//                t.putTreeVal(this, tab, hash, key, v);
//            else {
//                tab[i] = newNode(hash, key, v, first);
//                if (binCount >= TREEIFY_THRESHOLD - 1)
//                    treeifyBin(tab, hash);
//            }
//            ++modCount;
//            ++size;
//            afterNodeInsertion(true);
//        }
//        return v;
//    }
//
//    @Override
//    public V merge(K key, V value,
//                   BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
//        if (value == null)
//            throw new NullPointerException();
//        if (remappingFunction == null)
//            throw new NullPointerException();
//        int hash = hash(key);
//        Node<K, V>[] tab;
//        Node<K, V> first;
//        int n, i;
//        int binCount = 0;
//        TreeNode<K, V> t = null;
//        Node<K, V> old = null;
//        if (size > threshold || (tab = table) == null ||
//                (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        if ((first = tab[i = (n - 1) & hash]) != null) {
//            if (first instanceof TreeNode)
//                old = (t = (TreeNode<K, V>) first).getTreeNode(hash, key);
//            else {
//                Node<K, V> e = first;
//                K k;
//                do {
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k)))) {
//                        old = e;
//                        break;
//                    }
//                    ++binCount;
//                } while ((e = e.next) != null);
//            }
//        }
//        if (old != null) {
//            V v;
//            if (old.value != null)
//                v = remappingFunction.apply(old.value, value);
//            else
//                v = value;
//            if (v != null) {
//                old.value = v;
//                afterNodeAccess(old);
//            } else
//                removeNode(hash, key, null, false, true);
//            return v;
//        }
//        if (value != null) {
//            if (t != null)
//                t.putTreeVal(this, tab, hash, key, value);
//            else {
//                tab[i] = newNode(hash, key, value, first);
//                if (binCount >= TREEIFY_THRESHOLD - 1)
//                    treeifyBin(tab, hash);
//            }
//            ++modCount;
//            ++size;
//            afterNodeInsertion(true);
//        }
//        return value;
//    }
//
//    @Override
//    public void forEach(BiConsumer<? super K, ? super V> action) {
//        Node<K, V>[] tab;
//        if (action == null)
//            throw new NullPointerException();
//        if (size > 0 && (tab = table) != null) {
//            int mc = modCount;
//            for (int i = 0; i < tab.length; ++i) {
//                for (Node<K, V> e = tab[i]; e != null; e = e.next)
//                    action.accept(e.key, e.value);
//            }
//            if (modCount != mc)
//                throw new ConcurrentModificationException();
//        }
//    }
//
//    @Override
//    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
//        Node<K, V>[] tab;
//        if (function == null)
//            throw new NullPointerException();
//        if (size > 0 && (tab = table) != null) {
//            int mc = modCount;
//            for (int i = 0; i < tab.length; ++i) {
//                for (Node<K, V> e = tab[i]; e != null; e = e.next) {
//                    e.value = function.apply(e.key, e.value);
//                }
//            }
//            if (modCount != mc)
//                throw new ConcurrentModificationException();
//        }
//    }
//
//    /* ------------------------------------------------------------ */
//    // Cloning and serialization
//
//    /**
//     * Returns a shallow copy of this <tt>HashMap</tt> instance: the keys and
//     * values themselves are not cloned.
//     *
//     * @return a shallow copy of this map
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public Object clone() {
//        java.util.HashMap<K, V> result;
//        try {
//            result = (java.util.HashMap<K, V>) super.clone();
//        } catch (CloneNotSupportedException e) {
//            // this shouldn't happen, since we are Cloneable
//            throw new InternalError(e);
//        }
//        result.reinitialize();
//        result.putMapEntries(this, false);
//        return result;
//    }
//
//    // These methods are also used when serializing HashSets
//    final float loadFactor() {
//        return loadFactor;
//    }
//
//    final int capacity() {
//        return (table != null) ? table.length :
//                (threshold > 0) ? threshold :
//                        DEFAULT_INITIAL_CAPACITY;
//    }
//
//    /**
//     * Save the state of the <tt>HashMap</tt> instance to a stream (i.e.,
//     * serialize it).
//     *
//     * @serialData The <i>capacity</i> of the HashMap (the length of the
//     * bucket array) is emitted (int), followed by the
//     * <i>size</i> (an int, the number of key-value
//     * mappings), followed by the key (Object) and value (Object)
//     * for each key-value mapping.  The key-value mappings are
//     * emitted in no particular order.
//     */
//    private void writeObject(java.io.ObjectOutputStream s)
//            throws IOException {
//        int buckets = capacity();
//        // Write out the threshold, loadfactor, and any hidden stuff
//        s.defaultWriteObject();
//        s.writeInt(buckets);
//        s.writeInt(size);
//        internalWriteEntries(s);
//    }
//
//    /**
//     * Reconstitute the {@code HashMap} instance from a stream (i.e.,
//     * deserialize it).
//     */
//    private void readObject(java.io.ObjectInputStream s)
//            throws IOException, ClassNotFoundException {
//        // Read in the threshold (ignored), loadfactor, and any hidden stuff
//        s.defaultReadObject();
//        reinitialize();
//        if (loadFactor <= 0 || Float.isNaN(loadFactor))
//            throw new InvalidObjectException("Illegal load factor: " +
//                    loadFactor);
//        s.readInt();                // Read and ignore number of buckets
//        int mappings = s.readInt(); // Read number of mappings (size)
//        if (mappings < 0)
//            throw new InvalidObjectException("Illegal mappings count: " +
//                    mappings);
//        else if (mappings > 0) { // (if zero, use defaults)
//            // Size the table using given load factor only if within
//            // range of 0.25...4.0
//            float lf = Math.min(Math.max(0.25f, loadFactor), 4.0f);
//            float fc = (float) mappings / lf + 1.0f;
//            int cap = ((fc < DEFAULT_INITIAL_CAPACITY) ?
//                    DEFAULT_INITIAL_CAPACITY :
//                    (fc >= MAXIMUM_CAPACITY) ?
//                            MAXIMUM_CAPACITY :
//                            tableSizeFor((int) fc));
//            float ft = (float) cap * lf;
//            threshold = ((cap < MAXIMUM_CAPACITY && ft < MAXIMUM_CAPACITY) ?
//                    (int) ft : Integer.MAX_VALUE);
//            @SuppressWarnings({"rawtypes", "unchecked"})
//            Node<K, V>[] tab = (Node<K, V>[]) new Node[cap];
//            table = tab;
//
//            // Read the keys and values, and put the mappings in the HashMap
//            for (int i = 0; i < mappings; i++) {
//                @SuppressWarnings("unchecked")
//                K key = (K) s.readObject();
//                @SuppressWarnings("unchecked")
//                V value = (V) s.readObject();
//                putVal(hash(key), key, value, false, false);
//            }
//        }
//    }
//
//    /* ------------------------------------------------------------ */
//    // iterators
//
//    abstract class HashIterator {
//        Node<K, V> next;        // next entry to return
//        Node<K, V> current;     // current entry
//        int expectedModCount;  // for fast-fail
//        int index;             // current slot
//
//        HashIterator() {
//            expectedModCount = modCount;
//            Node<K, V>[] t = table;
//            current = next = null;
//            index = 0;
//            if (t != null && size > 0) { // advance to first entry
//                do {
//                } while (index < t.length && (next = t[index++]) == null);
//            }
//        }
//
//        public final boolean hasNext() {
//            return next != null;
//        }
//
//        final Node<K, V> nextNode() {
//            Node<K, V>[] t;
//            Node<K, V> e = next;
//            if (modCount != expectedModCount)
//                throw new ConcurrentModificationException();
//            if (e == null)
//                throw new NoSuchElementException();
//            if ((next = (current = e).next) == null && (t = table) != null) {
//                do {
//                } while (index < t.length && (next = t[index++]) == null);
//            }
//            return e;
//        }
//
//        public final void remove() {
//            Node<K, V> p = current;
//            if (p == null)
//                throw new IllegalStateException();
//            if (modCount != expectedModCount)
//                throw new ConcurrentModificationException();
//            current = null;
//            K key = p.key;
//            removeNode(hash(key), key, null, false, false);
//            expectedModCount = modCount;
//        }
//    }
//
//    final class KeyIterator extends HashIterator
//            implements Iterator<K> {
//        public final K next() {
//            return nextNode().key;
//        }
//    }
//
//    final class ValueIterator extends HashIterator
//            implements Iterator<V> {
//        public final V next() {
//            return nextNode().value;
//        }
//    }
//
//    final class EntryIterator extends HashIterator
//            implements Iterator<Map.Entry<K, V>> {
//        public final Map.Entry<K, V> next() {
//            return nextNode();
//        }
//    }
//
//    /* ------------------------------------------------------------ */
//    // spliterators
//
//    static class HashMapSpliterator<K, V> {
//        final java.util.HashMap<K, V> map;
//        Node<K, V> current;          // current node
//        int index;                  // current index, modified on advance/split
//        int fence;                  // one past last index
//        int est;                    // size estimate
//        int expectedModCount;       // for comodification checks
//
//        HashMapSpliterator(java.util.HashMap<K, V> m, int origin,
//                           int fence, int est,
//                           int expectedModCount) {
//            this.map = m;
//            this.index = origin;
//            this.fence = fence;
//            this.est = est;
//            this.expectedModCount = expectedModCount;
//        }
//
//        final int getFence() { // initialize fence and size on first use
//            int hi;
//            if ((hi = fence) < 0) {
//                java.util.HashMap<K, V> m = map;
//                est = m.size;
//                expectedModCount = m.modCount;
//                Node<K, V>[] tab = m.table;
//                hi = fence = (tab == null) ? 0 : tab.length;
//            }
//            return hi;
//        }
//
//        public final long estimateSize() {
//            getFence(); // force init
//            return (long) est;
//        }
//    }
//
//    static final class KeySpliterator<K, V>
//            extends HashMapSpliterator<K, V>
//            implements Spliterator<K> {
//        KeySpliterator(java.util.HashMap<K, V> m, int origin, int fence, int est,
//                       int expectedModCount) {
//            super(m, origin, fence, est, expectedModCount);
//        }
//
//        public KeySpliterator<K, V> trySplit() {
//            int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
//            return (lo >= mid || current != null) ? null :
//                    new KeySpliterator<>(map, lo, index = mid, est >>>= 1,
//                            expectedModCount);
//        }
//
//        public void forEachRemaining(Consumer<? super K> action) {
//            int i, hi, mc;
//            if (action == null)
//                throw new NullPointerException();
//            java.util.HashMap<K, V> m = map;
//            Node<K, V>[] tab = m.table;
//            if ((hi = fence) < 0) {
//                mc = expectedModCount = m.modCount;
//                hi = fence = (tab == null) ? 0 : tab.length;
//            } else
//                mc = expectedModCount;
//            if (tab != null && tab.length >= hi &&
//                    (i = index) >= 0 && (i < (index = hi) || current != null)) {
//                Node<K, V> p = current;
//                current = null;
//                do {
//                    if (p == null)
//                        p = tab[i++];
//                    else {
//                        action.accept(p.key);
//                        p = p.next;
//                    }
//                } while (p != null || i < hi);
//                if (m.modCount != mc)
//                    throw new ConcurrentModificationException();
//            }
//        }
//
//        public boolean tryAdvance(Consumer<? super K> action) {
//            int hi;
//            if (action == null)
//                throw new NullPointerException();
//            Node<K, V>[] tab = map.table;
//            if (tab != null && tab.length >= (hi = getFence()) && index >= 0) {
//                while (current != null || index < hi) {
//                    if (current == null)
//                        current = tab[index++];
//                    else {
//                        K k = current.key;
//                        current = current.next;
//                        action.accept(k);
//                        if (map.modCount != expectedModCount)
//                            throw new ConcurrentModificationException();
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }
//
//        public int characteristics() {
//            return (fence < 0 || est == map.size ? Spliterator.SIZED : 0) |
//                    Spliterator.DISTINCT;
//        }
//    }
//
//    static final class ValueSpliterator<K, V>
//            extends HashMapSpliterator<K, V>
//            implements Spliterator<V> {
//        ValueSpliterator(java.util.HashMap<K, V> m, int origin, int fence, int est,
//                         int expectedModCount) {
//            super(m, origin, fence, est, expectedModCount);
//        }
//
//        public ValueSpliterator<K, V> trySplit() {
//            int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
//            return (lo >= mid || current != null) ? null :
//                    new ValueSpliterator<>(map, lo, index = mid, est >>>= 1,
//                            expectedModCount);
//        }
//
//        public void forEachRemaining(Consumer<? super V> action) {
//            int i, hi, mc;
//            if (action == null)
//                throw new NullPointerException();
//            java.util.HashMap<K, V> m = map;
//            Node<K, V>[] tab = m.table;
//            if ((hi = fence) < 0) {
//                mc = expectedModCount = m.modCount;
//                hi = fence = (tab == null) ? 0 : tab.length;
//            } else
//                mc = expectedModCount;
//            if (tab != null && tab.length >= hi &&
//                    (i = index) >= 0 && (i < (index = hi) || current != null)) {
//                Node<K, V> p = current;
//                current = null;
//                do {
//                    if (p == null)
//                        p = tab[i++];
//                    else {
//                        action.accept(p.value);
//                        p = p.next;
//                    }
//                } while (p != null || i < hi);
//                if (m.modCount != mc)
//                    throw new ConcurrentModificationException();
//            }
//        }
//
//        public boolean tryAdvance(Consumer<? super V> action) {
//            int hi;
//            if (action == null)
//                throw new NullPointerException();
//            Node<K, V>[] tab = map.table;
//            if (tab != null && tab.length >= (hi = getFence()) && index >= 0) {
//                while (current != null || index < hi) {
//                    if (current == null)
//                        current = tab[index++];
//                    else {
//                        V v = current.value;
//                        current = current.next;
//                        action.accept(v);
//                        if (map.modCount != expectedModCount)
//                            throw new ConcurrentModificationException();
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }
//
//        public int characteristics() {
//            return (fence < 0 || est == map.size ? Spliterator.SIZED : 0);
//        }
//    }
//
//    static final class EntrySpliterator<K, V>
//            extends HashMapSpliterator<K, V>
//            implements Spliterator<Map.Entry<K, V>> {
//        EntrySpliterator(java.util.HashMap<K, V> m, int origin, int fence, int est,
//                         int expectedModCount) {
//            super(m, origin, fence, est, expectedModCount);
//        }
//
//        public EntrySpliterator<K, V> trySplit() {
//            int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
//            return (lo >= mid || current != null) ? null :
//                    new EntrySpliterator<>(map, lo, index = mid, est >>>= 1,
//                            expectedModCount);
//        }
//
//        public void forEachRemaining(Consumer<? super Map.Entry<K, V>> action) {
//            int i, hi, mc;
//            if (action == null)
//                throw new NullPointerException();
//            java.util.HashMap<K, V> m = map;
//            Node<K, V>[] tab = m.table;
//            if ((hi = fence) < 0) {
//                mc = expectedModCount = m.modCount;
//                hi = fence = (tab == null) ? 0 : tab.length;
//            } else
//                mc = expectedModCount;
//            if (tab != null && tab.length >= hi &&
//                    (i = index) >= 0 && (i < (index = hi) || current != null)) {
//                Node<K, V> p = current;
//                current = null;
//                do {
//                    if (p == null)
//                        p = tab[i++];
//                    else {
//                        action.accept(p);
//                        p = p.next;
//                    }
//                } while (p != null || i < hi);
//                if (m.modCount != mc)
//                    throw new ConcurrentModificationException();
//            }
//        }
//
//        public boolean tryAdvance(Consumer<? super Map.Entry<K, V>> action) {
//            int hi;
//            if (action == null)
//                throw new NullPointerException();
//            Node<K, V>[] tab = map.table;
//            if (tab != null && tab.length >= (hi = getFence()) && index >= 0) {
//                while (current != null || index < hi) {
//                    if (current == null)
//                        current = tab[index++];
//                    else {
//                        Node<K, V> e = current;
//                        current = current.next;
//                        action.accept(e);
//                        if (map.modCount != expectedModCount)
//                            throw new ConcurrentModificationException();
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }
//
//        public int characteristics() {
//            return (fence < 0 || est == map.size ? Spliterator.SIZED : 0) |
//                    Spliterator.DISTINCT;
//        }
//    }
//
//    /* ------------------------------------------------------------ */
//    // LinkedHashMap support
//
//
//    /*
//     * The following package-protected methods are designed to be
//     * overridden by LinkedHashMap, but not by any other subclass.
//     * Nearly all other internal methods are also package-protected
//     * but are declared final, so can be used by LinkedHashMap, view
//     * classes, and HashSet.
//     */
//
//    // Create a regular (non-tree) node 创建一个新节点
//    Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
//        return new Node<>(hash, key, value, next);
//    }
//
//    // For conversion from TreeNodes to plain nodes
//    Node<K, V> replacementNode(Node<K, V> p, Node<K, V> next) {
//        return new Node<>(p.hash, p.key, p.value, next);
//    }
//
//    // Create a tree bin node
//    TreeNode<K, V> newTreeNode(int hash, K key, V value, Node<K, V> next) {
//        return new TreeNode<>(hash, key, value, next);
//    }
//
//    // For treeifyBin  将链表数据 转换成 红黑树节点
//    TreeNode<K, V> replacementTreeNode(Node<K, V> p, Node<K, V> next) {
//        return new TreeNode<>(p.hash, p.key, p.value, next);
//    }
//
//    /**
//     * Reset to initial default state.  Called by clone and readObject.
//     */
//    void reinitialize() {
//        table = null;
//        entrySet = null;
//        keySet = null;
//        values = null;
//        modCount = 0;
//        threshold = 0;
//        size = 0;
//    }
//
//    // HashMap 访问、添加、删除、回调。
//    // Callbacks to allow LinkedHashMap post-actions
//    void afterNodeAccess(Node<K, V> p) {
//    }
//
//    void afterNodeInsertion(boolean evict) {
//    }
//
//    void afterNodeRemoval(Node<K, V> p) {
//    }
//
//    // Called only from writeObject, to ensure compatible ordering.
//    void internalWriteEntries(java.io.ObjectOutputStream s) throws IOException {
//        Node<K, V>[] tab;
//        if (size > 0 && (tab = table) != null) {
//            for (int i = 0; i < tab.length; ++i) {
//                for (Node<K, V> e = tab[i]; e != null; e = e.next) {
//                    s.writeObject(e.key);
//                    s.writeObject(e.value);
//                }
//            }
//        }
//    }
//
//    /* ------------------------------------------------------------ */
//    // Tree bins
//
//    /**
//     * Entry for Tree bins. Extends LinkedHashMap.Entry (which in turn
//     * extends Node) so can be used as extension of either regular or
//     * linked node.
//     *
//     * 红黑树节点表示
//     *
//     */
//    static final class TreeNode<K, V> extends LinkedHashMap.Entry<K, V> {
//        TreeNode<K, V> parent;  // red-black tree links
//        TreeNode<K, V> left;
//        TreeNode<K, V> right;
//        TreeNode<K, V> prev;    // needed to unlink next upon deletion
//        boolean red;
//
//        TreeNode(int hash, K key, V val, Node<K, V> next) {
//            super(hash, key, val, next);
//        }
//
//        /**
//         * Returns root of tree containing this node.
//         */
//        final TreeNode<K, V> root() {
//            for (TreeNode<K, V> r = this, p; ; ) {
//                if ((p = r.parent) == null)
//                    return r;
//                r = p;
//            }
//        }
//
//        /**
//         * Ensures that the given root is the first node of its bin.
//         */
//        static <K, V> void moveRootToFront(Node<K, V>[] tab, TreeNode<K, V> root) {
//            int n;
//            if (root != null && tab != null && (n = tab.length) > 0) {
//                int index = (n - 1) & root.hash;
//                TreeNode<K, V> first = (TreeNode<K, V>) tab[index];
//                if (root != first) {
//                    Node<K, V> rn;
//                    tab[index] = root;
//                    TreeNode<K, V> rp = root.prev;
//                    if ((rn = root.next) != null)
//                        ((TreeNode<K, V>) rn).prev = rp;
//                    if (rp != null)
//                        rp.next = rn;
//                    if (first != null)
//                        first.prev = root;
//                    root.next = first;
//                    root.prev = null;
//                }
//                assert checkInvariants(root);
//            }
//        }
//
//        /**
//         * Finds the node starting at root p with the given hash and key.
//         * The kc argument caches comparableClassFor(key) upon first use
//         * comparing keys.
//         *
//         * 从根节点开始查找
//         *
//         */
//        final TreeNode<K, V> find(int h, Object k, Class<?> kc) {
//            TreeNode<K, V> p = this;
//            do {
//                int ph, dir;
//                K pk;
//                TreeNode<K, V> pl = p.left, pr = p.right, q;
//                if ((ph = p.hash) > h)
//                    p = pl;
//                else if (ph < h)
//                    p = pr;
//                else if ((pk = p.key) == k || (k != null && k.equals(pk)))
//                    return p;
//                else if (pl == null)
//                    p = pr;
//                else if (pr == null)
//                    p = pl;
//                else if ((kc != null ||
//                        (kc = comparableClassFor(k)) != null) &&
//                        (dir = compareComparables(kc, k, pk)) != 0)
//                    p = (dir < 0) ? pl : pr;
//                else if ((q = pr.find(h, k, kc)) != null)
//                    return q;
//                else
//                    p = pl;
//            } while (p != null);
//            return null;
//        }
//
//        /**
//         * Calls find for root node.
//         *
//         * 获取红黑树中指定节点数据
//         */
//        final TreeNode<K, V> getTreeNode(int h, Object k) {
//            return ((parent != null) ? root() : this).find(h, k, null);
//        }
//
//        /**
//         * Tie-breaking utility for ordering insertions when equal
//         * hashCodes and non-comparable. We don't require a total
//         * order, just a consistent insertion rule to maintain
//         * equivalence across rebalancings. Tie-breaking further than
//         * necessary simplifies testing a bit.
//         */
//        static int tieBreakOrder(Object a, Object b) {
//            int d;
//            if (a == null || b == null ||
//                    (d = a.getClass().getName().
//                            compareTo(b.getClass().getName())) == 0)
//                d = (System.identityHashCode(a) <= System.identityHashCode(b) ?
//                        -1 : 1);
//            return d;
//        }
//
//        /**
//         * Forms tree of the nodes linked from this node.
//         *
//         * @return root of tree
//         */
//        final void treeify(Node<K, V>[] tab) {
//            TreeNode<K, V> root = null;
//            for (TreeNode<K, V> x = this, next; x != null; x = next) {
//                next = (TreeNode<K, V>) x.next;
//                x.left = x.right = null;
//                if (root == null) {
//                    x.parent = null;
//                    x.red = false;
//                    root = x;
//                } else {
//                    K k = x.key;
//                    int h = x.hash;
//                    Class<?> kc = null;
//                    for (TreeNode<K, V> p = root; ; ) {
//                        int dir, ph;
//                        K pk = p.key;
//                        if ((ph = p.hash) > h)
//                            dir = -1;
//                        else if (ph < h)
//                            dir = 1;
//                        else if ((kc == null &&
//                                (kc = comparableClassFor(k)) == null) ||
//                                (dir = compareComparables(kc, k, pk)) == 0)
//                            dir = tieBreakOrder(k, pk);
//
//                        TreeNode<K, V> xp = p;
//                        if ((p = (dir <= 0) ? p.left : p.right) == null) {
//                            x.parent = xp;
//                            if (dir <= 0)
//                                xp.left = x;
//                            else
//                                xp.right = x;
//                            root = balanceInsertion(root, x);
//                            break;
//                        }
//                    }
//                }
//            }
//            moveRootToFront(tab, root);
//        }
//
//        /**
//         * Returns a list of non-TreeNodes replacing those linked from
//         * this node.
//         */
//        final Node<K, V> untreeify(java.util.HashMap<K, V> map) {
//            Node<K, V> hd = null, tl = null;
//            for (Node<K, V> q = this; q != null; q = q.next) {
//                Node<K, V> p = map.replacementNode(q, null);
//                if (tl == null)
//                    hd = p;
//                else
//                    tl.next = p;
//                tl = p;
//            }
//            return hd;
//        }
//
//        /**
//         * Tree version of putVal.
//         */
//        final TreeNode<K, V> putTreeVal(java.util.HashMap<K, V> map, Node<K, V>[] tab,
//                                                          int h, K k, V v) {
//            Class<?> kc = null;
//            boolean searched = false;
//            TreeNode<K, V> root = (parent != null) ? root() : this;
//            for (TreeNode<K, V> p = root; ; ) {
//                int dir, ph;
//                K pk;
//                if ((ph = p.hash) > h)
//                    dir = -1;
//                else if (ph < h)
//                    dir = 1;
//                else if ((pk = p.key) == k || (k != null && k.equals(pk)))
//                    return p;
//                else if ((kc == null &&
//                        (kc = comparableClassFor(k)) == null) ||
//                        (dir = compareComparables(kc, k, pk)) == 0) {
//                    if (!searched) {
//                        TreeNode<K, V> q, ch;
//                        searched = true;
//                        if (((ch = p.left) != null &&
//                                (q = ch.find(h, k, kc)) != null) ||
//                                ((ch = p.right) != null &&
//                                        (q = ch.find(h, k, kc)) != null))
//                            return q;
//                    }
//                    dir = tieBreakOrder(k, pk);
//                }
//
//                TreeNode<K, V> xp = p;
//                if ((p = (dir <= 0) ? p.left : p.right) == null) {
//                    Node<K, V> xpn = xp.next;
//                    TreeNode<K, V> x = map.newTreeNode(h, k, v, xpn);
//                    if (dir <= 0)
//                        xp.left = x;
//                    else
//                        xp.right = x;
//                    xp.next = x;
//                    x.parent = x.prev = xp;
//                    if (xpn != null)
//                        ((TreeNode<K, V>) xpn).prev = x;
//                    moveRootToFront(tab, balanceInsertion(root, x));
//                    return null;
//                }
//            }
//        }
//
//        /**
//         * Removes the given node, that must be present before this call.
//         * This is messier than typical red-black deletion code because we
//         * cannot swap the contents of an interior node with a leaf
//         * successor that is pinned by "next" pointers that are accessible
//         * independently during traversal. So instead we swap the tree
//         * linkages. If the current tree appears to have too few nodes,
//         * the bin is converted back to a plain bin. (The test triggers
//         * somewhere between 2 and 6 nodes, depending on tree structure).
//         */
//        final void removeTreeNode(java.util.HashMap<K, V> map, Node<K, V>[] tab,
//                                  boolean movable) {
//            int n;
//            if (tab == null || (n = tab.length) == 0)
//                return;
//            int index = (n - 1) & hash;
//            TreeNode<K, V> first = (TreeNode<K, V>) tab[index], root = first, rl;
//            TreeNode<K, V> succ = (TreeNode<K, V>) next, pred = prev;
//            if (pred == null)
//                tab[index] = first = succ;
//            else
//                pred.next = succ;
//            if (succ != null)
//                succ.prev = pred;
//            if (first == null)
//                return;
//            if (root.parent != null)
//                root = root.root();
//            if (root == null || root.right == null ||
//                    (rl = root.left) == null || rl.left == null) {
//                tab[index] = first.untreeify(map);  // too small
//                return;
//            }
//            TreeNode<K, V> p = this, pl = left, pr = right, replacement;
//            if (pl != null && pr != null) {
//                TreeNode<K, V> s = pr, sl;
//                while ((sl = s.left) != null) // find successor
//                    s = sl;
//                boolean c = s.red;
//                s.red = p.red;
//                p.red = c; // swap colors
//                TreeNode<K, V> sr = s.right;
//                TreeNode<K, V> pp = p.parent;
//                if (s == pr) { // p was s's direct parent
//                    p.parent = s;
//                    s.right = p;
//                } else {
//                    TreeNode<K, V> sp = s.parent;
//                    if ((p.parent = sp) != null) {
//                        if (s == sp.left)
//                            sp.left = p;
//                        else
//                            sp.right = p;
//                    }
//                    if ((s.right = pr) != null)
//                        pr.parent = s;
//                }
//                p.left = null;
//                if ((p.right = sr) != null)
//                    sr.parent = p;
//                if ((s.left = pl) != null)
//                    pl.parent = s;
//                if ((s.parent = pp) == null)
//                    root = s;
//                else if (p == pp.left)
//                    pp.left = s;
//                else
//                    pp.right = s;
//                if (sr != null)
//                    replacement = sr;
//                else
//                    replacement = p;
//            } else if (pl != null)
//                replacement = pl;
//            else if (pr != null)
//                replacement = pr;
//            else
//                replacement = p;
//            if (replacement != p) {
//                TreeNode<K, V> pp = replacement.parent = p.parent;
//                if (pp == null)
//                    root = replacement;
//                else if (p == pp.left)
//                    pp.left = replacement;
//                else
//                    pp.right = replacement;
//                p.left = p.right = p.parent = null;
//            }
//
//            TreeNode<K, V> r = p.red ? root : balanceDeletion(root, replacement);
//
//            if (replacement == p) {  // detach
//                TreeNode<K, V> pp = p.parent;
//                p.parent = null;
//                if (pp != null) {
//                    if (p == pp.left)
//                        pp.left = null;
//                    else if (p == pp.right)
//                        pp.right = null;
//                }
//            }
//            if (movable)
//                moveRootToFront(tab, r);
//        }
//
//        /**
//         * Splits nodes in a tree bin into lower and upper tree bins,
//         * or untreeifies if now too small. Called only from resize;
//         * see above discussion about split bits and indices.
//         *
//         * @param map   the map
//         * @param tab   the table for recording bin heads
//         * @param index the index of the table being split
//         * @param bit   the bit of hash to split on
//         */
//        final void split(java.util.HashMap<K, V> map, Node<K, V>[] tab, int index, int bit) {
//            TreeNode<K, V> b = this;
//            // Relink into lo and hi lists, preserving order
//            TreeNode<K, V> loHead = null, loTail = null;
//            TreeNode<K, V> hiHead = null, hiTail = null;
//            int lc = 0, hc = 0;
//            for (TreeNode<K, V> e = b, next; e != null; e = next) {
//                next = (TreeNode<K, V>) e.next;
//                e.next = null;
//                if ((e.hash & bit) == 0) {
//                    if ((e.prev = loTail) == null)
//                        loHead = e;
//                    else
//                        loTail.next = e;
//                    loTail = e;
//                    ++lc;
//                } else {
//                    if ((e.prev = hiTail) == null)
//                        hiHead = e;
//                    else
//                        hiTail.next = e;
//                    hiTail = e;
//                    ++hc;
//                }
//            }
//
//            if (loHead != null) {
//                if (lc <= UNTREEIFY_THRESHOLD)
//                    tab[index] = loHead.untreeify(map);
//                else {
//                    tab[index] = loHead;
//                    if (hiHead != null) // (else is already treeified)
//                        loHead.treeify(tab);
//                }
//            }
//            if (hiHead != null) {
//                if (hc <= UNTREEIFY_THRESHOLD)
//                    tab[index + bit] = hiHead.untreeify(map);
//                else {
//                    tab[index + bit] = hiHead;
//                    if (loHead != null)
//                        hiHead.treeify(tab);
//                }
//            }
//        }
//
//        /* ------------------------------------------------------------ */
//        // Red-black tree methods, all adapted from CLR
//
//        static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> root,
//                                                                  TreeNode<K, V> p) {
//            TreeNode<K, V> r, pp, rl;
//            if (p != null && (r = p.right) != null) {
//                if ((rl = p.right = r.left) != null)
//                    rl.parent = p;
//                if ((pp = r.parent = p.parent) == null)
//                    (root = r).red = false;
//                else if (pp.left == p)
//                    pp.left = r;
//                else
//                    pp.right = r;
//                r.left = p;
//                p.parent = r;
//            }
//            return root;
//        }
//
//        static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> root,
//                                                                   TreeNode<K, V> p) {
//            TreeNode<K, V> l, pp, lr;
//            if (p != null && (l = p.left) != null) {
//                if ((lr = p.left = l.right) != null)
//                    lr.parent = p;
//                if ((pp = l.parent = p.parent) == null)
//                    (root = l).red = false;
//                else if (pp.right == p)
//                    pp.right = l;
//                else
//                    pp.left = l;
//                l.right = p;
//                p.parent = l;
//            }
//            return root;
//        }
//
//        static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> root,
//                                                                        TreeNode<K, V> x) {
//            x.red = true;
//            for (TreeNode<K, V> xp, xpp, xppl, xppr; ; ) {
//                if ((xp = x.parent) == null) {
//                    x.red = false;
//                    return x;
//                } else if (!xp.red || (xpp = xp.parent) == null)
//                    return root;
//                if (xp == (xppl = xpp.left)) {
//                    if ((xppr = xpp.right) != null && xppr.red) {
//                        xppr.red = false;
//                        xp.red = false;
//                        xpp.red = true;
//                        x = xpp;
//                    } else {
//                        if (x == xp.right) {
//                            root = rotateLeft(root, x = xp);
//                            xpp = (xp = x.parent) == null ? null : xp.parent;
//                        }
//                        if (xp != null) {
//                            xp.red = false;
//                            if (xpp != null) {
//                                xpp.red = true;
//                                root = rotateRight(root, xpp);
//                            }
//                        }
//                    }
//                } else {
//                    if (xppl != null && xppl.red) {
//                        xppl.red = false;
//                        xp.red = false;
//                        xpp.red = true;
//                        x = xpp;
//                    } else {
//                        if (x == xp.left) {
//                            root = rotateRight(root, x = xp);
//                            xpp = (xp = x.parent) == null ? null : xp.parent;
//                        }
//                        if (xp != null) {
//                            xp.red = false;
//                            if (xpp != null) {
//                                xpp.red = true;
//                                root = rotateLeft(root, xpp);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> root,
//                                                                       TreeNode<K, V> x) {
//            for (TreeNode<K, V> xp, xpl, xpr; ; ) {
//                if (x == null || x == root)
//                    return root;
//                else if ((xp = x.parent) == null) {
//                    x.red = false;
//                    return x;
//                } else if (x.red) {
//                    x.red = false;
//                    return root;
//                } else if ((xpl = xp.left) == x) {
//                    if ((xpr = xp.right) != null && xpr.red) {
//                        xpr.red = false;
//                        xp.red = true;
//                        root = rotateLeft(root, xp);
//                        xpr = (xp = x.parent) == null ? null : xp.right;
//                    }
//                    if (xpr == null)
//                        x = xp;
//                    else {
//                        TreeNode<K, V> sl = xpr.left, sr = xpr.right;
//                        if ((sr == null || !sr.red) &&
//                                (sl == null || !sl.red)) {
//                            xpr.red = true;
//                            x = xp;
//                        } else {
//                            if (sr == null || !sr.red) {
//                                if (sl != null)
//                                    sl.red = false;
//                                xpr.red = true;
//                                root = rotateRight(root, xpr);
//                                xpr = (xp = x.parent) == null ?
//                                        null : xp.right;
//                            }
//                            if (xpr != null) {
//                                xpr.red = (xp == null) ? false : xp.red;
//                                if ((sr = xpr.right) != null)
//                                    sr.red = false;
//                            }
//                            if (xp != null) {
//                                xp.red = false;
//                                root = rotateLeft(root, xp);
//                            }
//                            x = root;
//                        }
//                    }
//                } else { // symmetric
//                    if (xpl != null && xpl.red) {
//                        xpl.red = false;
//                        xp.red = true;
//                        root = rotateRight(root, xp);
//                        xpl = (xp = x.parent) == null ? null : xp.left;
//                    }
//                    if (xpl == null)
//                        x = xp;
//                    else {
//                        TreeNode<K, V> sl = xpl.left, sr = xpl.right;
//                        if ((sl == null || !sl.red) &&
//                                (sr == null || !sr.red)) {
//                            xpl.red = true;
//                            x = xp;
//                        } else {
//                            if (sl == null || !sl.red) {
//                                if (sr != null)
//                                    sr.red = false;
//                                xpl.red = true;
//                                root = rotateLeft(root, xpl);
//                                xpl = (xp = x.parent) == null ?
//                                        null : xp.left;
//                            }
//                            if (xpl != null) {
//                                xpl.red = (xp == null) ? false : xp.red;
//                                if ((sl = xpl.left) != null)
//                                    sl.red = false;
//                            }
//                            if (xp != null) {
//                                xp.red = false;
//                                root = rotateRight(root, xp);
//                            }
//                            x = root;
//                        }
//                    }
//                }
//            }
//        }
//
//        /**
//         * Recursive invariant check
//         */
//        static <K, V> boolean checkInvariants(TreeNode<K, V> t) {
//            TreeNode<K, V> tp = t.parent, tl = t.left, tr = t.right,
//                    tb = t.prev, tn = (TreeNode<K, V>) t.next;
//            if (tb != null && tb.next != t)
//                return false;
//            if (tn != null && tn.prev != t)
//                return false;
//            if (tp != null && t != tp.left && t != tp.right)
//                return false;
//            if (tl != null && (tl.parent != t || tl.hash > t.hash))
//                return false;
//            if (tr != null && (tr.parent != t || tr.hash < t.hash))
//                return false;
//            if (t.red && tl != null && tl.red && tr != null && tr.red)
//                return false;
//            if (tl != null && !checkInvariants(tl))
//                return false;
//            if (tr != null && !checkInvariants(tr))
//                return false;
//            return true;
//        }
//    }
//
//
//}
