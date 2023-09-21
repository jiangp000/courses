#include <iostream>
#include <vector>

using namespace  std;


// 测试数组是否从小到大排序，包含等于
void testTrue(vector<int> nums){
    cout << "Is Sorted: ";
    for(int i = 1; i < nums.size() - 1; i++){
        if(nums[i - 1] > nums[i]) {
            cout << false << endl;
            return;
        }
    }
    cout << true << endl;
    return;
}

// 顺序打印数组，包括排序前和排序后两种状态
void print(vector<int>& nums, int status){
    if(status)  cout << "Before: ";
    else        cout << "After: ";
    for(int i = 0; i < nums.size(); i++) cout << nums[i] << " ";
    cout << endl;
}

// 插入排序

void insetSort(vector<int>& nums){
    for(int i = 1; i < nums.size(); ++i){
        int j = i - 1, temp = nums[i];
        for(; j >= 0; j--){
            if(nums[j] <= temp) break;
            else nums[j + 1] = nums[j];
        }
        nums[j + 1] = temp;
    }
}

// 快速排序

void quickSort(vector<int>& nums, int m, int n){
    if(m > n) return;
    int i = m - 1, j = n + 1, t = nums[m];
    while(i < j){
        do i++; while(nums[i] <= t);
        do j--; while(nums[j] > t);
        if(i < j) swap(nums[i], nums[j]);
    }
    quickSort(nums, m, j - 1);
    quickSort(nums, j + 1, n);
}
// 测试函数1，插入排序
void testSort1(){
    vector<int> arr = {0, 9, 3, 4, 1, 2, 0, -1, 2, 3};
    testTrue(arr);
    print(arr, 0);
    insetSort(arr);
    print(arr, 1);
    testTrue(arr);
}

void testSort2(){
    vector<int> arr = {0, 9, 3, 4, 1, 2, 0, -1, 2, 3};
    testTrue(arr);
    print(arr, 0);
    quickSort(arr, 0, arr.size() - 1);
    print(arr, 1);
    testTrue(arr);
}

int main() {
    testSort2();

}
