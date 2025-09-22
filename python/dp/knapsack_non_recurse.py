def knapsack(values: list, weights: list, capacity: int) -> list:
    num_items = len(values)

    # create (len(values) + 1) X (capacity + 1) table and initialize with 0
    lookup_table: list = [[0 for col in range(capacity + 1)] for row in range(num_items + 1)]

    for item in range(num_items + 1):
        for c in range(capacity + 1):
            if item == 0 or c == 0:
                lookup_table[item][c] = 0
            elif weights[item - 1] <= c:
                # Case 2, n belongs to optimal solution
                lookup_table[item][c] = values[item - 1] + lookup_table[item - 1][c - weights[item - 1]]
            else:
                lookup_table[item][c] = lookup_table[item - 1][c]

    print(lookup_table)
    return lookup_table


def reconstruction(optimal_values: list, values: list, weights: list, capacity: int) -> set:
    num_items = len(values)
    remaining_capacity = capacity
    optimal_items = set()
    for i in range(num_items, 0, -1):
        cur_item_weight = weights[i - 1]
        if cur_item_weight <= remaining_capacity and \
                optimal_values[i - 1][remaining_capacity - cur_item_weight] + values[i - 1] >= optimal_values[i - 1][remaining_capacity]:
            # This is case 2 where we include this item in optimal solution
            optimal_items.add(i - 1)
            remaining_capacity -= cur_item_weight
    return optimal_items


if __name__ == '__main__':
    profits = [1, 6, 10, 16]  # The values of the jewelry
    weights = [1, 2, 3, 5]  # The weight of each
    num_items = len(profits)
    optimal_values = knapsack(profits, weights, 7)
    print("Max value in knapsack = ", optimal_values[num_items][7])
    print("Items in knapsack = ", reconstruction(optimal_values, profits, weights, 7))

    optimal_values = knapsack(profits, weights, 6)
    print("Max value in knapsack = ", optimal_values[num_items][6])
    print("Items in knapsack = ", reconstruction(optimal_values, profits, weights, 6))

    optimal_values = knapsack(profits, weights, 4)
    print("Max value in knapsack = ", optimal_values[num_items][4])
    print("Optimal items = ", reconstruction(optimal_values, profits, weights, 4))
    v = [3, 2, 4, 4]
    w = [4, 3, 2, 3]
    optimal_values = knapsack(v, w, 6)
    print("Max value in knapsack = ", optimal_values[4][6])
    print("Optimal items = ", reconstruction(optimal_values, v, w, 6))
