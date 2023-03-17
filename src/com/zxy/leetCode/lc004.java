package com.zxy.leetCode;


import java.util.*;

public class lc004 {
    public static void main(String[] args) {
        lc547();
    }

    private static void lc547() {
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfsCity(isConnected, visited, cities, i);
                provinces++;
            }
        }
        System.out.println("provinces:" + provinces);
    }

    private static void dfsCity(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfsCity(isConnected, visited, cities, j);
            }
        }
    }

    /**
     * [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
     */
    private static void lc554() {
        List<List<Integer>> wall = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> line : wall) {
            int n = line.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += line.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int maxMap = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxMap = Math.max(maxMap, entry.getValue());
        }
        System.out.println(wall.size() - maxMap);
    }

    private static void lc179() {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        System.out.println(Arrays.toString(strArr));
        Arrays.sort(strArr, (x, y) -> (y + x).compareTo(x + y));
        if (strArr[0].equals("0")) {
            System.out.println("0");
            return;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
        }
        System.out.println(sb.toString());
    }

    /**
     * 3[a]10[bc]
     * 3[a2[c]]
     */
    private static void lc394() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuffer sb = new StringBuffer();
        Stack digit = new Stack();
        Stack letter = new Stack();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                digit.push(k);
                letter.push(sb.toString());
                k = 0;
                sb.setLength(0);
            } else if (c == ']') {
                int num = Integer.parseInt(String.valueOf(digit.pop()));
                StringBuffer temp = new StringBuffer();
                for (int j = 0; j < num; j++) {
                    temp.append(sb);
                }
                String res = String.valueOf(letter.pop());
                sb = new StringBuffer(res + temp);
            } else if (Character.isDigit(c)) {
                k = k * 10 + Integer.parseInt(c + "");
                System.out.println("k=" + k);
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }

    private static void lc475() {
        int ans = 0;
        int[] houses = new int[]{1, 2, 3, 4, 5, 6};
        int[] heaters = new int[]{1, 4};
        Arrays.sort(heaters);
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int curDistance = Math.min(leftDistance, rightDistance);
            System.out.println("i = " + i + ",j = " + j + ",curDistance = " + curDistance);
            ans = Math.max(ans, curDistance);
        }
        System.out.println("--------------" + ans);
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[left] > target) {
            return -1;
        }
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void lc46() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        //-----------
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }

    private static void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * aaaa
     * abcabcbb
     */
    public static void lc3() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                j = Math.max(max, hashMap.get(c) + 1);
            }
            hashMap.put(c, i);
            max = Math.max(max, i - j + 1);
        }
    }

    /**
     * 73 74 75 71 69 72 76 73
     */
    public static void lc739() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] temp = new int[strings.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.parseInt(strings[i]);
        }
        int[] answer = new int[strings.length];
        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < temp.length; i++) {
            int currTemp = temp[i];
            while (!stack.isEmpty() && currTemp > temp[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(answer));
    }

    public static void lc781() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] answers = new int[strings.length];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(answers);
        int ans = 0;
        for (int i = 0; i < answers.length; i++) {
            int ack = answers[i];
            ans += ack + 1;
            int step = ack;
            while (step-- > 0 && i + 1 < answers.length && answers[i] == answers[i + 1]) i++;
        }
        System.out.println(ans);
    }

    public static void lc1190() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuffer sb = new StringBuffer();
        Deque deque = new LinkedList();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                deque.push(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                sb.reverse();
                sb.insert(0, deque.pop());
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());

    }

    public static void lc45() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        int steps = 0;
        int maxPosition = 0;
        int endPosition = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            maxPosition = Math.max(maxPosition, arr[i] + i);
            if (i == endPosition) {
                endPosition = maxPosition;
                steps++;
            }
        }
        System.out.println(steps);
    }
}
