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
     <version>0.2.0-SNAPSHOT</version>
  </dependency>
</dependencies>
```

* Gradle:
```groovy
repositories {
  maven { url 'https://mvn.smashup.ru/releases' }
}

dependencies {
  implementation 'ru.leonidm:FastNBT:0.2.0-SNAPSHOT'
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

    // You can also use getLinkedList or getLinkedCompound methods to put required entity
    // right into the NBT if NBT doesn't contains given key. It's useful when you are going\
    // to save compound right after the setters. But you should know that these methods will
    // throw exceptions in read-only mode.
    writeNbtItem.getLinkedCompound("MyCompound").setString("SomeKey", "SomeValue");

    // I do not recommend to set Mojang keys like "CustomModelData" using FastNBTItem, because it will
    // will work only if provided ItemStack is instance of CraftItemStack, which is not always true.
}
```

### Entities
```java
Entity entity = event.getEntity();
FastNBTEntity nbtEntity = FastNBTEntity.wrap(entity);

UUID entityUuid = nbtEntity.getUUID("UUID");

nbtEntity.setBoolean("NoGravity", true);

// If you want to save custom tags, use persistent compound
nbtEntity.getLinkedPersistentCompound().setBoolean("MyOwnTag", false);

// You can save only this persistent compound that is really fast 
nbtEntity.savePersistentCompound();

// Or you can save the whole entity, but it requires more time, and also
// I don't see any purpose to use such method, because usual Minecraft
// tags can be easily changed via API provided by Bukkit
nbtEntity.save();
```

# TODO:
* FastNBTBlock
* Fix problem with Mojang keys in default ItemStacks
* More supported MC versions
