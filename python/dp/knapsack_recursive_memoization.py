
def recursive_memoization(lookup_table: list, values: list, weights: list, capacity: int, cur_index: int) -> int:
    num_items = len(values)

    # base case
    if (cur_index < 0 or cur_index >= num_items) or capacity <= 0:
        return 0

    # lookup from cache, if available
    if lookup_table[cur_index][capacity] != 0:
        return lookup_table[cur_index][capacity]

    value_cur_item_included = 0
    if weights[cur_index] <= capacity:
        # reduce capacity by weight of this item
        new_capacity: int = capacity - weights[cur_index]
        value_cur_item_included = values[cur_index] + recursive_memoization(lookup_table, values, weights, new_capacity, cur_index + 1)

    value_cur_item_excluded = recursive_memoization(lookup_table, values, weights, capacity, cur_index + 1)

    lookup_table[cur_index][capacity] = max(value_cur_item_included, value_cur_item_excluded)
    return lookup_table[cur_index][capacity]


def knapsack_helper(values: list, weights: list, capacity: int) -> int:

    # create (len(values) + 1) X (capacity + 1) table and initialize with 0
    lookup_table: list = [[0 for col in range(capacity + 1)] for row in range(len(values) + 1)]

    max_value = recursive_memoization(lookup_table, values, weights, capacity, 0)
    print(lookup_table)
    return max_value


if __name__ == '__main__':
    values: list = [3, 2, 3]
    weights: list = [2, 2, 3]
    capacity: int = 5
    optimum: int = knapsack_helper(values, weights, capacity)
    print(optimum)
