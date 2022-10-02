def merge_sort(items: list):
    if len(items) <= 1:
        return items

    mid = len(items) // 2
    left = items[:mid]
    right = items[mid:]

    left = merge_sort(left)
    right = merge_sort(right)
    return merge(left, right)


def merge(left: list, right: list):
    merged_list = []
    left_index = 0
    right_index = 0

    while left_index < len(left) and right_index < len(right):
        if left[left_index] > right[right_index]:
            merged_list.append(right[left_index])
            right_index += 1
        else:
            merged_list.append(left[left_index])
            left_index += 1

    merged_list += left[left_index:]
    merged_list += right[right_index:]

    return merged_list


print(merge_sort(items=[5, 8, 1, 7, 4, 0, 2, 3]))
