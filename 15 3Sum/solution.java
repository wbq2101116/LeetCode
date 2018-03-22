class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<String> set = new HashSet();
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
	if (nums.length >= 3 && nums[0] == nums[nums.length - 1] && nums[0] == 0) {
		List<Integer> list = new ArrayList();
		list.add(0);
		list.add(0);
		list.add(0);
		res.add(list);
		return res;
	}
        for (int i = 0; i < nums.length - 2; i++) {
		int begin = i + 1;
		int end = nums.length -1;
		while (end > begin) {
			if (nums[i] + nums[begin] + nums[end] == 0) {
				String s = nums[i] + " " + nums[begin] + " " + nums[end];
				if (set.contains(s)) {
					begin++;
					continue;
				}
				else {
					set.add(s);
				}
				List<Integer> list = new ArrayList();
				list.add(nums[i]);
				list.add(nums[begin]);
				list.add(nums[end]);
				res.add(list);
				begin++;
				continue;
			}
			else if (nums[i] + nums[begin] + nums[end] < 0) {
				begin++;
			}
			else {
				end --;
			}
		}
            /*for (int j = i + 1; j < nums.length; j++) {
                int begin = j + 1;
                int end = nums.length - 1;
                int mid = (begin + end) / 2;
                while (begin <= end) {
                    if (nums[i] + nums[j] + nums[mid] == 0) {
                        String s = nums[i] + " " + nums[j] + " " + nums[mid];
                        if (set.contains(s)) {
                            break;
                        }
                        else {
                            set.add(s);
                        }
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[mid]);
                        res.add(list);
                        break;
                    }
                    else if (nums[i] + nums[j] + nums[mid] < 0) {
                        begin = mid + 1;
                        mid = (begin + end) / 2;
                    }
                    else {
                        end = mid - 1;
                        mid = (begin + end) / 2;
                    }
                }
            }*/
        }
        return res;
    }
}
