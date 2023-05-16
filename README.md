# FastNBT
As fast as possible library for NBT.

### Why is it fast as possible?
* Single calls to Java reflection only during initialization unlike **NBTAPI**
* Read-only NBT mode
* There is no any locks or synchronizations _(in other words, it is not multithreaded)_

## Supported versions:
* **v1_19_R1** *(1.19.1 — 1.19.2)*

## Importing

* Maven:
```xml
<repositories>
  <repository>
    <id>smashup-repository</id>
    <name>SmashUp Repository</name>
    <url>https://mvn.smashup.ru/releases</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>ru.leonidm</groupId>
    <artifactId>FastNBT</artifactId>
    <version>0.1.2-SNAPSHOT</version>
  </dependency>
</dependencies>
```

* Gradle:
```groovy
repositories {
  maven { url 'https://mvn.smashup.ru/releases' }
}

dependencies {
  implementation 'ru.leonidm:FastNBT:0.1.2-SNAPSHOT'
}
```

## Usage
### Items
```java
PlayerInventory inventory = player.getInventory();
ItemStack itemStack = inventory.getItem(1);
if (itemStack != null && !itemStack.getType().isAir()) {
    // FastNBtItem.read(ItemStack) can be used when you need just to get some values and no more.
    // For such interactions there is read-only mode, which is more faster in specific cases than read-write mode
    FastNBTItem nbtItem = FastNBTItem.read(itemStack);
    
    int customModelData = nbtItem.getInt("CustomModelData");
    
    FastNBTCompound nbtCompound = nbtItem.getCompound("display");
    FastNBTList<FastNBTCompound> nbtList = nbtItem.getList("Enchantments", FastNBTType.COMPOUND);
    for (FastNBTCompound listCompound : nbtList) {
        int value = listCompound.getInt("Key");
    }
    
    nbtItem.setInt("SomeKey", 1); // Will throw an exception, because nbtItem is read-only
    
    // If the second argument is "true", then all changes will be applied on given ItemStack,
    // otherwise on the copy of it. The new instance can be taken with method FastNBTItem#getOrigin().
    FastNBTItem writeNbtItem = FastNBTItem.write(itemStack, true);
    writeNbtItem.setInt("SomeKey", 1); // Will not throw any exception

    // I do not recommend to set Mojang keys like "CustomModelData" using FastNBTItem, because it will
    // will work only if provided ItemStack is instance of CraftItemStack, which is not always true.
}
```

# TODO:
* FastNBTEntity
* FastNBTBlock
* Fix problem with Mojang keys in default ItemStacks
* More supported MC versions
