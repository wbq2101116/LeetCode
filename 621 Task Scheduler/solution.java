class Solution {
    public int leastInterval(char[] tasks, int n) {
        // hashmap
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            char ch = tasks[i];
            if (charMap.containsKey(ch)) {
                charMap.replace(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        // print
        // printHashMap(charMap);

        // priority queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Set<Map.Entry<Character, Integer>> entries = charMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            priorityQueue.add(entry.getValue());
        }

        // print
        // System.out.println(Arrays.toString(priorityQueue.toArray()));

        int res = 0;

        Map<Character, Integer> charVisited = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        while (priorityQueue.size() != 0) {
            // System.out.println("***");
            // System.out.println("res : " + res);
            for (int i = 0; i < n + 1; i++) {
                // System.out.println("------");
                if (priorityQueue.size() == 0) {
                    if (list.size() != 0) {
                        res += n - i + 1;
                    }
                    break;
                }

                int select = priorityQueue.poll();
                // System.out.println("select : " + select);

                Character ch = getKey(charMap, select);
                // System.out.println("ch : " + ch);

                // System.out.println(Arrays.toString(priorityQueue.toArray()));
                // printHashMap(charVisited);
                /*if (null == ch) {
                    priorityQueue.add(select);
                    res++;
                    continue;
                }
*/
                if (select - 1 != 0) {
                    list.add(select - 1);
                    // priorityQueue.add(select - 1);
                }
                // System.out.println(Arrays.toString(priorityQueue.toArray()));


                int tmp = charMap.get(ch) - 1;
                if (0 == tmp) {
                    charMap.remove(ch);
                } else {
                    charMap.remove(ch);
                    charVisited.put(ch, tmp);
                }
                res++;
            }
            priorityQueue.addAll(list);
            list.clear();
            charMap.putAll(charVisited);
            charVisited.clear();
        }
        return res;
    }

    public Character getKey(Map<Character, Integer> map, int value) {
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return null;
    }
/*
    public void printHashMap(Map<Character, Integer> map) {
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            // System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
        }
    }
    */
}


