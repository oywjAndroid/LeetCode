#### 1、二分搜索框架

```java
int binarySearch(int[] nums,int target){
  // ... 表示可能出现细节问题
  int left = 0;
  int right = ...;
  while(...){
    int mid = left + (right - left) / 2;
    if (nums[mid] == target){
      ...
    }else if (nums[mid] < target){
      left = ...;
    }else if (nums[mid] > target){
      right = ...;
    }
  }
  return ...;
}
```

#### 2、二分搜索的细节问题

* 如何确定while循环的条件是`<=`，还是`<` ？

  取决于初始化`right`的赋值是 `num.length - 1`,还是`num.length`。

  前者相当于两端都是闭区间`[left,right]`，后者相当于左闭右开区间`[left,right)`。

  假设：使用二分法在`[1,2,2,2,6]`中查找`target=6`，如果现在使用闭区间作为`搜索区间`，`while`循环条件为`<`,当区间缩小为[4,4]时就会跳出循环导致target搜索失败。

  ```java
  public int binarySearch(int[] nums,int target){
    int left = 0;
    int right = nums.length - 1;
    // 此处搜索区间为[left,right],但是while循环条件为left < right,
    // while跳出循环的条件为：left == right，其对应的区间为[left,right]，这样当left==right的时候就会跳出循环，导致某些情况被跳过
    // 如：nums=[1,2,3] target = 3，这种情况下就会导致返回-1
    while(left < right){
      int mid = left + (right - left) / 2;
      if(nums[mid] == target){
        return mid;
      }else if(nums[mid] < target){
        left = mid + 1;
      }else if(nums[mid] > target){
        right = mid - 1;
      }
    }
    return -1;
  }
  ```

  `总结：明确搜索区间，搜索区间选择全闭区间则while条件需要为<=，如果选择左闭右开的区间则while条件需要为<。`

#### 3、二分搜索算法的局限性

如：nums=[1,2,2,2,6] ，target=2 使用上述代码查询会 return 2，虽然结果没错，但是很多情况下，我们想得到的都是targe的左侧边界，即索引1，或者target的右边界，即索引3。这种情况上述算法是无法处理的。

##### 3.1 寻找左侧边界的二分搜索

```java

```

