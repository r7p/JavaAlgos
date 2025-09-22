
def knapsack_recursive(values: list, weights: list, capacity: int, cur_index: int) -> int:
    num_items = len(values)

    # base case
    if (cur_index < 0 or cur_index >= num_items) or capacity <= 0:
        return 0

    value_cur_item_included = 0
    if weights[cur_index] <= capacity:
        # reduce capacity by weight of this item
        new_capacity: int = capacity - weights[cur_index]
        value_cur_item_included = values[cur_index] + knapsack_recursive(values, weights, new_capacity, cur_index + 1)

    value_cur_item_excluded = knapsack_recursive(values, weights, capacity, cur_index + 1)

    return max(value_cur_item_included, value_cur_item_excluded)


if __name__ == '__main__':
    values: list = [3, 2, 3]
    weights: list = [2, 2, 3]
    capacity: int = 5
    optimum: int = knapsack_recursive(values, weights, capacity, 0)
    print(optimum)
