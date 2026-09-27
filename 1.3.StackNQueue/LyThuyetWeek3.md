# Lời giải chi tiết COS226 Midterm f24 - Câu 6

## (a) Bắt đầu từ một queue rỗng, chuỗi sau sẽ in ra nội dung gì?

**Chuỗi thao tác:** 
`enqueue(0), enqueue(1), dequeue(), enqueue(2), enqueue(3), dequeue(), enqueue(4), enqueue(5), dequeue(), enqueue(6), enqueue(7), dequeue()`

**Quy tắc:** Hàng đợi tự in nội dung ra chuẩn sau mỗi 3 thao tác (enqueue hoặc dequeue). Tổng cộng có 12 thao tác, do đó sẽ có đúng 4 lần in ra màn hình.

Mô phỏng chi tiết từng bước:
1. enqueue(0) -> Q = [0]
2. enqueue(1) -> Q = [0, 1]
3. dequeue() -> Q = [1] (lấy ra 0). 
   * [In lần 1 - Thao tác thứ 3]: Nội dung queue là 1 -> In: **1**
4. enqueue(2) -> Q = [1, 2]
5. enqueue(3) -> Q = [1, 2, 3]
6. dequeue() -> Q = [2, 3] (lấy ra 1). 
   * [In lần 2 - Thao tác thứ 6]: Nội dung queue là 2, 3 -> In: **2 3**
7. enqueue(4) -> Q = [2, 3, 4]
8. enqueue(5) -> Q = [2, 3, 4, 5]
9. dequeue() -> Q = [3, 4, 5] (lấy ra 2). 
   * [In lần 3 - Thao tác thứ 9]: Nội dung queue là 3, 4, 5 -> In: **3 4 5**
10. enqueue(6) -> Q = [3, 4, 5, 6]
11. enqueue(7) -> Q = [3, 4, 5, 6, 7]
12. dequeue() -> Q = [4, 5, 6, 7] (lấy ra 3). 
    * [In lần 4 - Thao tác thứ 12]: Nội dung queue là 4, 5, 6, 7 -> In: **4 5 6 7**

Ghép các lần in lại theo thứ tự (cách nhau bởi dấu cách), ta được chuỗi: 
`1 2 3 3 4 5 4 5 6 7`

* **Đáp án đúng:** **`1 2 3 3 4 5 4 5 6 7.`** (Lựa chọn đầu tiên)

---

## (b) Thao tác enqueue của self-printing queue chứa n phần tử có thời gian chạy trong trường hợp tồi nhất là loại nào?

* **Giải thích:** Bình thường, thao tác enqueue trong danh sách liên kết mất thời gian O(1). Tuy nhiên, cứ sau 3 thao tác, hàng đợi sẽ tự động in toàn bộ n phần tử hiện có ra chuẩn. Việc duyệt và in toàn bộ hàng đợi có kích thước n mất thời gian O(n). Do đó, trong trường hợp tồi nhất (thao tác kích hoạt việc in), thời gian chạy sẽ là O(n).
* **Đáp án đúng:** **O(n)**

---

## (c) Thời gian chạy trung bình (amortized) trên mỗi thao tác đối với n thao tác enqueue() và dequeue() là bao nhiêu?

* **Giải thích:** 
  - Các thao tác thông thường mất thời gian O(1), tổng cộng cho n thao tác là O(n).
  - Các thao tác in diễn ra khoảng n/3 lần. Lần in thứ i (khi kích thước queue cỡ 3i) mất thời gian tỉ lệ thuận với kích thước hiện tại của queue. 
  - Tổng thời gian cho tất cả các lần in trong chuỗi n thao tác là tổng từ i = 1 đến n/3 của O(i), tương đương O(n^2).
  - Thời gian amortized tính trên mỗi thao tác được xác định bằng tổng thời gian chia cho số thao tác n: O(n^2) / n = O(n).
* **Đáp án đúng:** **O(n)**