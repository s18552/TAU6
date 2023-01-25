package zad2;

import org.assertj.core.api.Condition;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(EasyMockExtension.class)
public class FriendshipsMongoEasyMockTest {

    @TestSubject
    FriendshipsMongo friendships = new FriendshipsMongo();

    //A nice mock expects recorded calls in any order and returning null for other calls
    @Mock(type = MockType.NICE)
    FriendsCollection friends;

    @Test
    public void mockingWorksAsExpected(){
        Person joe = new Person("Joe");
        //Zapisanie zachowania - co sie ma stac
        expect(friends.findByName("Joe")).andReturn(joe);
        //Odpalenie obiektu do sprawdzenia zachowania
        replay(friends);
        assertThat(friends.findByName("Joe")).isEqualTo(joe);
    }

    @Test
    public void alexDoesNotHaveFriends(){
        assertThat(friendships.getFriendsList("Alex")).isEmpty();
    }

    @Test
    public void joeHas5Friends(){
        List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
        Person joe = createMock(Person.class);
        expect(friends.findByName("Joe")).andReturn(joe);
        expect(joe.getFriends()).andReturn(expected);
        replay(friends);
        replay(joe);
        assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
    }

    @Test
    public void checkNewFriend(){
        Person p = createMock(Person.class);
        expect(friends.findByName("Alex")).andReturn(p);
        replay(friends);
        replay(p);
        assertThat(friends.findByName("Alex")).isNotNull().isEqualTo(p);
    }

}
