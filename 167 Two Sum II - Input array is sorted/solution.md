# Two Sum II - Input array is sorted

------

[TOC]

------

## Solution



### Approach #1: two-pointer

#### Description

#### Complexity Analysis

##### Time complexity: O(n)

##### Space complexity: 



### Approach #2: dictionary

#### Description

#### Complexity Analysis

##### Time complexity: 

##### Space complexity: 



### Approach #3: binary search

#### Description

#### Complexity Analysis

##### Time complexity: O(n * log(n))

##### Space complexity: 



### Approach #4: A O(logN) binary search

#### Description

the standard O(N) solution uses left++ and right-- to move the pointers to the desired solution. This can be made more efficient, in O(log(N)) as mentioned, by not moving the pointers one step at a time, but many steps at a time using binary search.

#### Complexity Analysis

##### Time complexity: O(log(n))

##### Space complexity: 



------

## Summary

1. Modified version of "dictionary" solution. (try except)

2. We don't repeat investigating the elements that have been already investigated. ???

3. Arrays.binarySearch();

https://discuss.leetcode.com/topic/21800/python-different-solutions-two-pointer-dictionary-binary-search
