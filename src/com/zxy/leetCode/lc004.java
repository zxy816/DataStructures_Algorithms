package com.zxy.leetCode;


import java.util.*;

public class lc004 {
    public static void main(String[] args) {
        lc46();
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
